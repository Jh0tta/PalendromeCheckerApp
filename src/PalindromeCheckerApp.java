/**
 * ================================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This program demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters from the input string are inserted into both
 * the queue and the stack.
 *
 * The queue removes characters from the front (FIFO),
 * while the stack removes characters from the top (LIFO).
 *
 * By comparing the dequeued and popped characters,
 * we can determine whether the string is a palindrome.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * @author Developer
 * @version 6.0
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Step 1: Declare and initialize the input string
        // ------------------------------------------------------------
        String input = "madam";

        // ------------------------------------------------------------
        // Step 2: Create Queue and Stack data structures
        // Queue -> FIFO behavior
        // Stack -> LIFO behavior
        // ------------------------------------------------------------
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // ------------------------------------------------------------
        // Step 3: Insert characters into both Queue and Stack
        // Queue -> enqueue (add)
        // Stack -> push
        // ------------------------------------------------------------
        for (char c : input.toCharArray()) {
            queue.add(c);   // enqueue into queue
            stack.push(c);  // push into stack
        }

        // ------------------------------------------------------------
        // Step 4: Assume the string is a palindrome initially
        // ------------------------------------------------------------
        boolean isPalindrome = true;

        // ------------------------------------------------------------
        // Step 5: Compare characters removed from Queue and Stack
        // Queue -> remove()  (FIFO)
        // Stack -> pop()     (LIFO)
        // ------------------------------------------------------------
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove(); // dequeue
            char fromStack = stack.pop();    // pop

            if (fromQueue != fromStack) {
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