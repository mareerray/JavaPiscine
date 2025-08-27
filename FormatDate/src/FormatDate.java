import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {
    // --------------------------------------------------------------
    // returns a formatted string using the date as parameter.
    // Input: 2021, 8, 22, 13, 25, 46
    // Output: Le 22 août de l'an 2021 à 13h25m et 46s
    // French-style date and time
    public static String formatToFullText(LocalDateTime dateTime) {
        DateTimeFormatter frFormatter = DateTimeFormatter.ofPattern(
                "'Le' d MMMM 'de l''an' yyyy 'à' HH'h'mm'm et 'ss's'", Locale.FRENCH);
        return dateTime.format(frFormatter);
        // 'de l''an' in the pattern produces: de l'an
    }

    // --------------------------------------------------------------
    // returns a formatted string using the date as parameter.
    // Input: 2022, 2, 13
    // Output: febbraio 13 22
    // Italian-style date (month first)
    public static String formatSimple(LocalDate date) {
        DateTimeFormatter itFormatter = DateTimeFormatter.ofPattern(
                "MMMM dd yy", Locale.ITALIAN);
        return date.format(itFormatter);
        // "MMMM" is full month, "dd" is day, "yy" is two-digit year.
    }

    // --------------------------------------------------------------
    // returns a formatted string using the time as parameter.
    // Input: 16, 18, 56, 8495847
    // Output: 16:18:56.8495847
    public static String formatIso(LocalTime time) {
        DateTimeFormatter nanoFormatter = DateTimeFormatter.ofPattern(
                "HH:mm:ss.n");
        return time.format(nanoFormatter);
        // "n" gives full nanoseconds (up to 9 digits), "SSS" gives milliseconds.
    }

}