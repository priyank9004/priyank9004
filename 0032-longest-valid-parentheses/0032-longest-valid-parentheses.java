import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base/sentinel index to handle edge cases 
        // where the valid substring starts from index 0
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Store the index of the open parenthesis
                stack.push(i);
            } else {
                // Pop the last unmatched '(' or the current sentinel index
                stack.pop();

                if (stack.isEmpty()) {
                    // If empty, the current ')' is unmatched. 
                    // Push its index as the new sentinel boundary.
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }
}
