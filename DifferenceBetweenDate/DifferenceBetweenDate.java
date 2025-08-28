import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {
    // --------------------------------------------------------------
    // returns the duration between the times as parameter. Must always be positive.
    // Input:  LocalTime.of(12, 54, 32), LocalTime.of(21, 23, 53)
    // Output: 8H29M21S
    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        // Handle null input
        if (localTime1 == null || localTime2 == null) return null;

        Duration diff = Duration.between(localTime1, localTime2);

        if (diff.isNegative()) diff = diff.abs();
        return diff;
        /* If you want a formatted string like "8H29M21S":
        long hours = diff.toHours();
        long minutes = diff.toMinutes() % 60;
        long seconds = getSeconds() % 60;
        return String.format("%dH%dM%dS", hours, minutes, seconds); */
    }

    // --------------------------------------------------------------
    // returns the period between the dates as parameter.Must always be positive.
    // Input:  LocalDate.of(2020, 10, 13), LocalDate.of(2022, 5, 8)
    // Output: 1Y6M25D
    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        // Handle null input
        if (date1 == null || date2 == null) return null;

        // Calculate duration
        Period diff = Period.between(date1, date2);

        // Make duration always positive
        if (diff.isNegative()) {
            diff = Period.between(date2, date1);
        }
        return diff;
        /* If you want a formatted string like "1Y6M25D":
        int years = diff.getYears();
        int months = diff.getMonths();
        int days = diff.getDays();
        return String.format("%dY%dM%dD", years, months, days);*/
    }

    // --------------------------------------------------------------
    // returns the number of hours between the date times as parameter. Must always be positive.
    // Input:  LocalDateTime.of(2022, 4, 12, 16, 18, 56), LocalDateTime.of(2022, 5, 10, 21, 54, 56)
    // Output: 677
    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // Handle null input
        if (dateTime1 == null || dateTime2 == null) return null;

        // Calculate duration and get total hours as a positive value
        Duration diff = Duration.between(dateTime1, dateTime2);

        // Make period always positive
        long hours = Math.abs(diff.toHours());
        return hours;
    }
}