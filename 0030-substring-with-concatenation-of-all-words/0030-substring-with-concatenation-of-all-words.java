import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return ans;
        }

        int m = s.length();
        int n = words.length;
        int k = words[0].length();
        int totalLen = n * k;

        // Step 1: Build the frequency map for the initial words array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Step 2: Run a sliding window for every possible word-offset (0 to k-1)
        for (int i = 0; i < k; ++i) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            
            // Keep sliding the right bound of the window
            while (right + k <= m) {
                // Cut the next word segment
                String word = s.substring(right, right + k);
                right += k;

                // Case A: The word isn't part of our dictionary at all
                if (!wordCount.containsKey(word)) {
                    seenWords.clear();
                    left = right; // Reset window start to current right pointer
                    continue;
                }

                // Case B: The word is valid, increment its count in the window
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                // Case C: Over-concentration of a valid word
                // Shrink the window from the left until frequencies align
                while (seenWords.get(word) > wordCount.get(word)) {
                    String leftWord = s.substring(left, left + k);
                    seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                    left += k;
                }

                // If the entire span matches the required footprint length
                if (right - left == totalLen) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
