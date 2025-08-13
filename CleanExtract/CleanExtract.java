public class CleanExtract {
    public static String extract(String s) {
        if (s == null) {
            return "";
        }
        String[] parts = s.split("\\|"); // split into parts based on '|' and put into an array
        String result = ""; // start with an empty result

        // loop through each part
        for (String part : parts) {
            part = part.trim(); // remove spaces
            int firstDot = part.indexOf('.'); // find first and last dot
            int lastDot = part.lastIndexOf('.');
            String between = "";

            // if there are at least two dots, extract between them
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                // Two or more dots — take between first and last
                between = part.substring(firstDot + 1, lastDot).trim();
            } else if (firstDot != -1) {
                // Only one dot — take everything after it
                between = part.substring(firstDot + 1).trim();
            } else {
                // No dots - keep whole part
                between = part;
            }
            // only add " " when result is not empty
            if (!between.isEmpty()) {
                if (!result.isEmpty()) { // only add non-empty substrings
                    result += " ";
                }
                result += between;
            }
        }
        return result;
    }
}