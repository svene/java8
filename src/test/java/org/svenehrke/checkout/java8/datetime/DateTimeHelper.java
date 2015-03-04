package org.svenehrke.checkout.java8.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.*;
import java.util.function.Supplier;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;
import static org.junit.Assert.fail;

public class DateTimeHelper {
	public static void assertDateTimeParseException(String msg, Supplier supplier) {
		try {
			supplier.get();
			fail(msg + " should throw a DateTimeParseException");
		} catch (DateTimeParseException e) {
		}
	}

	public static LocalDate dateFromString(String input, DateTimeFormatter formatter) {
		return LocalDate.parse(input, formatter);
	}

	public static String formattedDate(LocalDate localDate, DateTimeFormatter formatter) {
		return formatter.format(localDate);
	}

	public static boolean isValidDate(String inDate, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
*/

	public static DateTimeFormatter dateFormatter() {
		return new DateTimeFormatterBuilder()
			.appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NEVER)
			.appendLiteral(".")
			.appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
			.appendLiteral(".")
			.appendValue(YEAR, 4)
			.optionalStart().toFormatter()
			.withResolverStyle(ResolverStyle.STRICT);
	}
}
