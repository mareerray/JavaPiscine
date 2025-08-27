import java.util.regex.*;

public class RegexMatch {
    // --------------------------------------------------------------
    // returns true if the string as parameter contains only alpha characters.
    // Input: "azejkdfhjsdf" Output: true
    // Input: "azejkd fhjsdf" Output: false
    public static boolean containsOnlyAlpha(String s) {
        if (s == null) return false;
        return s.matches("^[a-zA-Z]+$");
        // ^ and $ mark the beginning and end of the string, so the entire string must match.
        // [a-zA-Z]+ matches one or more alphabetic (ASCII) characters.
        // String.matches() is best for quick, simple, one-off checks.
        // Use Pattern and Matcher when you want performance,
        // advanced regex features, or to process many strings.
    }
    // --------------------------------------------------------------
    // returns true if the string as parameter starts with one letter and ends with one number.
    // Input: "asjd jd34jds jkfd6f5"  Output: true
    // Input: "asjd jd34jds jkfd6."   Output: false
    public static boolean startWithLetterAndEndWithNumber(String s) {
        if (s == null) return false;
        return s.matches("^[A-Za-z].*[0-9]$");
        // ^ means the start of the string.
        // [A-Za-z] ensures the string starts with a letter (uppercase or lowercase).
        // .* allows any characters in between.
        // [0-9]$ makes sure the string ends with a digit.
    }
    // --------------------------------------------------------------
    // returns true if the string as parameter contains at least 3 successive A.
    // Input: "sdjkAAAAAsdjksj"  Output: true
    // Input: "sdjkAAsdaaasdjksj"  Output: false
    public static boolean containsAtLeast3SuccessiveA(String s) {
        if (s == null) return false;
        return s.matches(".*A{3,}.*");
        // .* allows any characters before or after the group.
        // A{3,} looks for at least three consecutive A's anywhere in the string.
    }
}