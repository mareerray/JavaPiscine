public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        // reverse the string using StringBuilder
        String reversed = new StringBuilder(s).reverse().toString();
        // compare using .equalsIgnoreCase, so ignore case when comparing
        return s.equalsIgnoreCase(reversed);
    }
}