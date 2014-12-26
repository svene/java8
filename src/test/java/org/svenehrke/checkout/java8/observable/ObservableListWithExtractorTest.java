package org.svenehrke.checkout.java8.observable;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.util.Callback;
import org.junit.Test;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

public class ObservableListWithExtractorTest {

	public static class Person {
		StringProperty firstName = new SimpleStringProperty();
		StringProperty lastName = new SimpleStringProperty();

		public Person(String fn, String ln) {
			firstName.setValue(fn);
			lastName.setValue(ln);
		}

		public String getFirstName() {
			return firstName.get();
		}


		public String getLastName() {
			return lastName.get();
		}

		public static Callback<Person, Observable[]> extractor() {
			return (Person p) -> new Observable[]{p.firstName, p.lastName};
		}

	}

	@Test
	public void extractorAffectsFilteredList() throws Exception {

		ObservableList<Person> sourcePersons = FXCollections.observableArrayList(Person.extractor());
		ObservableList<Person> targetPersons = new FilteredList<>(sourcePersons, p -> p.firstName.getValue().contains("2"));
		Person p1 = new Person("f1", "l1");
		Person p2 = new Person("f2", "l2");
		sourcePersons.addAll(p1, p2);

		assertEquals("f1, f2", firstNames("source", sourcePersons));
		assertEquals("f2", firstNames("target", targetPersons));

		p1.firstName.setValue("f12");

		assertEquals("f12, f2", firstNames("source", sourcePersons));
		assertEquals("f12, f2", firstNames("target", targetPersons)); // NOTE: only contains 'f12' because extractor was used above
	}

	private String firstNames(String title, ObservableList<Person> people) {
		return people.stream().map(Person::getFirstName).collect(joining(", "));
	}
}
