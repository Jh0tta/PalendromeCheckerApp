/**
 * ================================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This application checks whether a given string is a palindrome
 * using a Singly Linked List data structure.
 *
 * A palindrome is a word, phrase, or sequence that reads the same
 * forward and backward.
 *
 * Instead of comparing characters directly from the string, this
 * approach demonstrates how palindrome validation can be performed
 * using Linked List traversal and manipulation.
 *
 * Algorithm Flow:
 * 1. Accept a string input from the user.
 * 2. Convert the string into a singly linked list where each node
 *    stores one character.
 * 3. Find the middle of the linked list using the slow and fast
 *    pointer technique.
 * 4. Reverse the second half of the linked list.
 * 5. Compare nodes from the first half and the reversed second half.
 * 6. If all characters match → the string is a palindrome.
 * 7. If any character differs → the string is not a palindrome.
 *
 * Key Concepts Demonstrated:
 * - Singly Linked List traversal
 * - Fast and slow pointer technique
 * - Linked list reversal
 * - Symmetric comparison of nodes
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 *
 * Example:
 * Input : "radar"
 *
 * Linked List:
 * r → a → d → a → r
 *
 * Step 1: Find middle (node 'd')
 * Step 2: Reverse second half
 *
 * First Half  : r → a
 * Second Half : r → a
 *
 * Step 3: Compare nodes
 *
 * Result: Palindrome
 *
 * @author Developer
 * @version 8.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * Node class representing a single element
     * in the singly linked list.
     */
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        // Convert string to linked list
        Node head = buildLinkedList(input);

        // Check palindrome
        boolean result = isPalindrome(head);

        // Display result
        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Converts a string into a singly linked list.
     *
     * @param text Input string
     * @return Head node of the linked list
     */
    public static Node buildLinkedList(String text) {

        Node head = null;
        Node tail = null;

        for (char c : text.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    /**
     * Checks if the linked list represents a palindrome.
     *
     * @param head Head node of the linked list
     * @return true if palindrome, otherwise false
     */
    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using slow and fast pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half of the list
        Node secondHalf = reverseList(slow);

        // Step 3: Compare first and second halves
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    /**
     * Reverses a singly linked list.
     *
     * @param head Starting node
     * @return New head of the reversed list
     */
    public static Node reverseList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}