import java.util.regex.*;
import java.util.*;

public class RegexReplace {
    // returns the string where the units cm and € are removed
    // if they follow directly a number and followed by a space.
    // Input: "32cm et 50€"  Output: 32 et 50
    // Input: "32 cm et 50 €"  Output: 32 cm et 50 €
    // Input: "32cms et 50€!"  Output: 32cms et 50€!
    public static String removeUnits(String s) {
        if (s == null || s.isEmpty()) return null;

        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }
        // Syntex: String result = myString.replaceAll(regex, replacement);
        // use capturing groups "()()()"
        // group1 (\\d+) means one or more digit
        // group2 (cm|€) means "cm" or "€"
        // group3 (?=\\s|$) means only if followed by a space OR end of string
        // backreferences $1 refers to the 1st group in replacement string to put the digits back
        // ex. "32cm et 50€" --> 32 et 50

    // --------------------------------------------------------------
    // returns a string where parts of email addresses are replaced
    // by '*' if they follow the rules below:
    // 1) Hide from the username any character next to -, . or _ if they exist.
    // Otherwise, hide 3 characters from the username if its length > 3
    // 2) If the remaining part after @ is in the format @<third level domain>.<second level domain>.<top level domain>,
    // then hide the third and top level domains, otherwise hide the second level domain
    // and the top level domain if it is not included in .com, .org and .net.
    // Input: "john.doe@example.com"  Output: john.***@*******.com
    // Input: "jann@example.co.org"  Output: jan*@*******.co.***
    // Input: "jackob@example.fr"  Output: jac***@*******.**
    public static String obfuscateEmail(String s) {
        // Return null for empty input
        if (s == null || s.isEmpty()) return null;
        // Split into username (before @) and domain (after @)
        String[] parts = s.split("@");
        String username = parts[0];
        String domain = parts[1];

        // Symbol to use for masking hidden characters
        String obfUsername;
        String hiddenChar = "*";

        // If the username contains a separator, mask all chars after the last one
        if (username.matches(".*[-._].*")) {
            // Find the index of the last separator (dot, dash or underscore)
            int lastSeparator = Math.max(username.lastIndexOf('.'),
                                Math.max(username.lastIndexOf('-'), username.lastIndexOf('_')));
            // Keep the username up to and including the last separator, then add masking
            obfUsername = username.substring(0,lastSeparator+1) + hiddenChar.repeat(username.length()-(lastSeparator+1));
        // Else, if username is longer than 3, keep first 3 characters and mask rest
        } else if (username.length() > 3) {
            obfUsername = username.substring(0,3) + hiddenChar.repeat(username.length()-3);
        // Else, leave username as is (if 3 or fewer characters)
        } else {
            obfUsername = username;
        }

        // Split domain at dot
        String[] domainParts = domain.split("\\.");
        String obfDomain = "";
        String hiddenFirst;
        String hiddenLast;

        // If domain has three parts (like a.b.c), mask first and last
        if (domainParts.length == 3) {
            hiddenFirst = hiddenChar.repeat(domainParts[0].length());
            hiddenLast = hiddenChar.repeat(domainParts[2].length());
            obfDomain = hiddenFirst + "." + domainParts[1] + "." + hiddenLast;
        // If domain has two parts (like a.b)
        } else if (domainParts.length == 2) {
            // ...and second part is com, org, or net: mask only the first part
            if (domainParts[1].matches("com|org|net")) {
                hiddenFirst = hiddenChar.repeat(domainParts[0].length());
                obfDomain = hiddenFirst + "." + domainParts[1];
            // ...otherwise, mask both parts
            } else {
                hiddenFirst = hiddenChar.repeat(domainParts[0].length());
                hiddenLast = hiddenChar.repeat(domainParts[1].length());
                obfDomain = hiddenFirst + "." + hiddenLast;
            }
        // For any other case, mask all letters in the domain
        } else {
            obfDomain = domain.replaceAll("[a-zA-Z]", "*");
        }
        // Return the full obfuscated email
        return obfUsername + "@" + obfDomain;
    }
}