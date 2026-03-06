/**
 * ================================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 7: Deque Based Optimized Palindrome Checker
 *
 * Description:
 * This application checks whether a given string is a palindrome
 * using a Deque (Double Ended Queue) data structure.
 *
 * A palindrome is a word, phrase, or sequence that reads the same
 * forward and backward.
 *
 * Instead of reversing the string, this approach performs an
 * efficient bidirectional comparison using a Deque.
 *
 * Algorithm Flow:
 * 1. Accept a string input from the user.
 * 2. Convert the string to lowercase (optional normalization).
 * 3. Insert each character of the string into a Deque.
 * 4. Repeatedly remove characters from the front and rear.
 * 5. Compare the removed characters.
 * 6. If any pair does not match → the string is NOT a palindrome.
 * 7. If all pairs match until the deque becomes empty or size=1
 *    → the string IS a palindrome.
 *
 * Deque Operations Used:
 * - addLast()     : Inserts character at the rear
 * - removeFirst() : Removes character from the front
 * - removeLast()  : Removes character from the rear
 *
 * Advantages of this approach:
 * - No string reversal required
 * - Efficient front-to-back comparison
 * - Demonstrates optimal bidirectional traversal
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 *
 * Example:
 * Input  : "level"
 * Deque  : [l, e, v, e, l]
 *
 * Step 1: removeFirst() = l
 *         removeLast()  = l
 *
 * Step 2: removeFirst() = e
 *         removeLast()  = e
 *
 * Step 3: Remaining element = v → stop
 *
 * Result: Palindrome
 *
 * @author Developer
 * @version 7.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC7.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Create scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call palindrome checking method
        boolean result = isPalindrome(input);

        // Display result
        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        // Close scanner to free resources
        scanner.close();
    }

    /**
     * Checks whether the given text is a palindrome using a Deque.
     *
     * @param text The input string to be checked
     * @return true if the string is a palindrome, otherwise false
     */
    public static boolean isPalindrome(String text) {

        // Create a Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters of the string into the deque
        for (char c : text.toLowerCase().toCharArray()) {
            deque.addLast(c);
        }

        // Compare characters from both ends
        while (deque.size() > 1) {

            // Remove character from the front
            char first = deque.removeFirst();

            // Remove character from the rear
            char last = deque.removeLast();

            // If characters do not match, it is not a palindrome
            if (first != last) {
                return false;
            }
        }

        // If all characters match, it is a palindrome
        return true;
    }
}