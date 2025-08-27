import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.*;

public class ParseDate {
    // --------------------------------------------------------------
    // returns a date object using the string as parameter.
    // Input: "2022-04-25T20:51:28.709039322" (Already in ISO format)
    // Output: 2022-04-25T20:51:28.709039322
    public static LocalDateTime parseIsoFormat(String stringDate) {
        LocalDateTime dt = LocalDateTime.parse(stringDate);
        return dt;
    }
        // LocalDateTime.parse(stringDate) automatically parses ISO-8601 formatted strings,
        // such as "2022-04-25T20:51:28.709039322"
        // No formatter is needed for this standard ISO format.

    // --------------------------------------------------------------
    // returns a date object using the string as parameter.
    // Input: "lundi 25 avril 2022"
    // Output: 2022-04-25
    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }
        // DateTimeFormatter is a class in Java that helps read (parse) or write (format) dates as strings.
        // The pattern "EEEE d MMMM yyyy" tells Java to expect the string to have:
        // EEEE: Full day of the week (like "lundi" for Monday)
        // d: Day of the month (number)
        // MMMM: Full month name (like "avril" for April)
        // yyyy: Four-digit year (like "2022")
        // Locale.FRENCH tells Java this date will use French words (so it can understand "lundi", "avril", etc).
        // LocalDate ld = LocalDate.parse(stringDate, formatter);
        // This line reads (parses) the input string using the formatter.
        // The result is returned as a LocalDate object.
        // When printed, it will show 2022-04-25, which is the standard ISO format for dates in Java.

    // --------------------------------------------------------------
    // returns a time object using the string as parameter.
    // Input: "09 heures du soir, 07 minutes et 23 secondes"
    // Output: 21:07:23
    public static LocalTime parseTimeFormat(String stringDate) {
        // Regex: \\d+ matches one or more digits
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(stringDate);

        int hour = 0, minute = 0, second = 0;

        if (m.find()) hour = Integer.parseInt(m.group());
        if (m.find()) minute = Integer.parseInt(m.group());
        if (m.find()) second = Integer.parseInt(m.group());

        if (stringDate.contains("du soir") && hour != 12) {
            hour += 12; // Convert to PM
        }
        return LocalTime.of(hour, minute, second);
    }
    /*
        Simple Explanation
        1. The Pattern
            Pattern p = Pattern.compile("\\d+");

        \\d means "digit" (0-9)

                    + means "one or more"

            So \\d+ matches any sequence of digits (like 09, 07, 23)

        2. The Matcher
            Matcher m = p.matcher(stringDate);

            This searches your input string for any groups of digits.

                    3. Extracting Numbers
        if (m.find()) hour = Integer.parseInt(m.group());
        if (m.find()) minute = Integer.parseInt(m.group());
        if (m.find()) second = Integer.parseInt(m.group());

            Each time m.find() is called, it finds the next group of digits.

            The first call finds the hours (09), the second finds the minutes (07), the third finds the seconds (23).

                    4. Adjusting for "du soir"
                    if (stringDate.contains("du soir") && hour != 12) hour += 12;

            If the phrase means PM (evening), add 12 to get 24-hour time (so "09" becomes "21")

        5. Build the Time
        return LocalTime.of(hour, minute, second);

        Now you have the correct numbers to make a LocalTime. */
}