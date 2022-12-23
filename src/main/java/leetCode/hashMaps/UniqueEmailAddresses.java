package leetCode.hashMaps;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    /*
    Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters,
    the email may contain one or more '.' or '+'.

    For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
    If you add periods '.' between some characters in the local name part of an email address, mail sent there will be
    forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain
    emails to be filtered. Note that this rule does not apply to domain names.

    For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    It is possible to use both of these rules at the same time.

    Given an array of strings emails where we send one email to each email[i], return the number of different addresses
    that actually receive mails.

    Example 1:
    Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
    Output: 2
    Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.

    Example 2:
    Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
    Output: 3

    Constraints:
        1 <= emails.length <= 100
        1 <= emails[i].length <= 100
        email[i] consist of lowercase English letters, '+', '.' and '@'.
        Each emails[i] contains exactly one '@' character.
        All local and domain names are non-empty.
        Local names do not start with a '+' character.
     */
    //TC: O(n * m) where n is the number of emails given and m is the length of the longest email given
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> sanitizedEmails = new HashSet<>();

        for (String email : emails) {
            String cleanedEmail = processEmail(email);
            sanitizedEmails.add(cleanedEmail);
        }
        return sanitizedEmails.size();
    }

    private String processEmail(String email) {
        StringBuilder sanitizedEmail = new StringBuilder();

        StringBuilder local = new StringBuilder(); // local name of email
        // extract the local name of the email
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            /*
                local name comes before @ and anything after a '+' is ignored so break when either of these characters
                are encountered
             */
            if (c == '+' || c == '@') {
                break;
            } else if (c != '.') {
                local.append(c);
            }
        }

//        String domain = email.substring(email.indexOf('@') + 1); // domain name of email | inefficient one liner
        StringBuilder domain = new StringBuilder();
        // start from the end of the email string up to '@'
        for (int i = email.length() - 1; i >= 0 && email.charAt(i) != '@'; i--) {
            domain.append(email.charAt(i));
        }

        return sanitizedEmail.append(local.toString()).append("@").append(domain.reverse().toString()).toString();
    }
}
