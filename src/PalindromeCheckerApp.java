/**
 * ================================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 5: Stack-Based Palindrome Checker
 *
 * Description:
 * This program checks whether a given string is a palindrome
 * using the Stack data structure. A Stack follows the
 * Last-In-First-Out (LIFO) principle.
 *
 * A palindrome is a word that reads the same forward and backward.
 * Examples: noon, madam, level.
 *
 * Program Flow:
 * 1. Declare and initialize an input string.
 * 2. Push each character of the string into a stack.
 * 3. Pop characters from the stack (which reverses the order).
 * 4. Compare the popped characters with the original string.
 * 5. If all characters match, the string is a palindrome.
 * 6. Print the result.
 *
 * Stack Concept Used:
 * - push(): Adds element to the top of the stack.
 * - pop(): Removes the top element from the stack.
 *
 * This approach uses the natural reversing behavior of a stack.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Step 1: Declare and initialize the input string
        // ------------------------------------------------------------
        String input = "noon";

        // ------------------------------------------------------------
        // Step 2: Create a Stack to store characters
        // ------------------------------------------------------------
        Stack<Character> stack = new Stack<>();

        // ------------------------------------------------------------
        // Step 3: Push each character of the string into the stack
        // This stores characters in LIFO structure
        // ------------------------------------------------------------
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // ------------------------------------------------------------
        // Step 4: Assume the string is a palindrome initially
        // ------------------------------------------------------------
        boolean isPalindrome = true;

        // ------------------------------------------------------------
        // Step 5: Iterate through the original string again
        // and compare with characters popped from the stack
        // ------------------------------------------------------------
        for (char c : input.toCharArray()) {

            // Pop character from stack and compare
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // ------------------------------------------------------------
        // Step 6: Display the result
        // ------------------------------------------------------------
        if (isPalindrome) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
}