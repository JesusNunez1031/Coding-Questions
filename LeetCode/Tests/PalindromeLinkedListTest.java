import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {
    PalindromeLinkedList driver = new PalindromeLinkedList();

    @Test
    @DisplayName("Non-palindrome list")
    void isPalindromeNonPalindrome1() throws Exception {
        ListNode head = new ListNode();
        head = head.makeList(new int[]{1, 2, 2, 3, 4});

        head.print(head);
        assertFalse(driver.isPalindrome(head));
        System.out.println("is not a palindrome");
    }

    @Test
    @DisplayName("Non-palindrome list")
    void isPalindromeNonPalindrome2() throws Exception {
        ListNode head = new ListNode();
        head = head.makeList(new int[]{1, 2, 2, 3, 4, 6, 4, 5});

        head.print(head);
        assertFalse(driver.isPalindrome(head));
        System.out.println("is not a palindrome");
    }

    @Test
    @DisplayName("Palindrome list")
    void isPalindromeValidPalindrome1() throws Exception {
        ListNode head = new ListNode();
        head = head.makeList(new int[]{1, 2, 2, 2, 1});

        head.print(head);
        assertTrue(driver.isPalindrome(head));
        System.out.println("is a palindrome");
    }

    @Test
    @DisplayName("Palindrome list")
    void isPalindromeValidPalindrome2() throws Exception {
        ListNode head = new ListNode();
        head = head.makeList(new int[]{1, 3, 3, 2, 3, 3, 1});

        head.print(head);
        assertTrue(driver.isPalindrome(head));
        System.out.println("is a palindrome");
    }
}