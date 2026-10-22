class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Base case: if the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Assume the first string is the entire common prefix to start with
        String prefix = strs[0];
        
        // Compare the prefix with every other string in the array
        for (int i = 1; i < strs.length; i++) {
            // Chop off the last character of the prefix until it is found 
            // at index 0 of the current string (strs[i])
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
