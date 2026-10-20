class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: Empty string matches empty pattern
        dp[0][0] = true;
        
        // Deal with patterns like a*, a*b*, or a*b*c* matching an empty string s
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    // Current characters match directly
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Two cases when encountering a '*'
                    
                    // Case 1: Match 0 occurrences of the preceding element (skip character and '*')
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match 1 or more occurrences of the preceding element
                    // The preceding character in pattern must match the current character in string
                    char precPatternChar = p.charAt(j - 2);
                    if (precPatternChar == sc || precPatternChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
