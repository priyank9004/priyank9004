import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Mapping of digits to corresponding telephone keypad letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base case: return an empty list if the input string is empty
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        // Start the recursive backtracking process
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Base case: if the current combination matches the length of digits, save it
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digitChar = digits.charAt(index);
        String letters = KEYPAD[digitChar - '0'];

        // Iterate through all possible letters for this digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));          // Choose
            backtrack(result, digits, current, index + 1); // Recurse
            current.deleteCharAt(current.length() - 1);  // Backtrack (Undo choice)
        }
    }
}
