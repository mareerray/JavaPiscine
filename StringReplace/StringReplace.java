public class StringReplace {
    //for handling chars
    public static String replace(String s, char target, char replacement) {
        if (s == null) {
            return null;
        }
        return s.replace(target, replacement);
    }
    //for handling substrings
    public static String replace(String s, String target, String replacement) {
        if (s == null) {
            return null;
        }
        if (target == null && replacement == null) {
            return s;
        }
        return s.replace(target, replacement);
    }

}