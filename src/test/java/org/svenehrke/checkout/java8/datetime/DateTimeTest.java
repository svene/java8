package org.svenehrke.checkout.java8.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.svenehrke.checkout.java8.datetime.DateTimeHelper.*;
import static org.svenehrke.checkout.java8.datetime.Tuple2.t;

public class DateTimeTest {

	public static final String PATTERN = "d.MM.yyyy";
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
	public static final DateTimeFormatter STRICT_FORMATTER = dateFormatter();

	@Test
	public void testName() throws Exception {

		Arrays.asList(
			t(LocalDate.ofEpochDay(0).toString(), "1970-01-01"),
			t(LocalDate.ofEpochDay(10_000).toString(), "1997-05-19"),
			t(LocalDate.ofEpochDay(20_000).toString(), "2024-10-04"),
			t(LocalDate.ofEpochDay(30_000).toString(), "2052-02-20"),
			t(LocalDate.ofEpochDay(900_000).toString(), "4434-02-12"),
			t(LocalDate.ofEpochDay(999999999).toString(), "+2739877-01-02")
		).forEach(it -> assertEquals(it.b, it.a));

	}

	@Test
	public void parsing() {
		Arrays.asList(
			t("28.02.2015", "2015-02-28"),
			t("29.02.2015", "2015-02-28"), // Note that the 29th is silently changed to the 28th !
			t("30.02.2015", "2015-02-28"),
			t("31.02.2015", "2015-02-28"),
			t("2.02.2015", "2015-02-02")
		).forEach(it -> assertEquals(it.b, dateFromString(it.a, FORMATTER).toString()));


		assertDateTimeParseException("parsing '32.02.2015'", () -> dateFromString("32.02.2015", FORMATTER));
	}

	@Test
	public void parsingStrict() {
		Arrays.asList(
			t("27.02.2015", "2015-02-27"),
			t("28.02.2015", "2015-02-28"),
			t("2.02.2015", "2015-02-02")
		).forEach(it -> assertEquals(it.b, dateFromString(it.a, STRICT_FORMATTER).toString()));

		Arrays.asList(
			"29.02.2015", "30.02.2015", "32.02.2015"
		).forEach(it -> assertDateTimeParseException(String.format("parsing '%s'", it), () -> dateFromString(it, STRICT_FORMATTER)));

	}

	@Test
	public void formatting() throws Exception {

		Arrays.asList(
			t("29.02.2015", "28.02.2015"),  // Note that the 29th is silently changed to the 28th !
			t("02.02.2015", "2.02.2015"),
			t("2.02.2015", "2.02.2015")
		).forEach(it -> assertEquals(it.b, formattedDate(dateFromString(it.a, FORMATTER), FORMATTER)));

	}


}
