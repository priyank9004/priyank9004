class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases: 
        // 1. Negative numbers are not palindromes (e.g., -121 because of the '-')
        // 2. Numbers ending in 0 are not palindromes, unless the number itself is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reversing half of the number
        while (x > reversedHalf) {
            reversedHalf = (reversedHalf * 10) + (x % 10);
            x /= 10;
        }

        // For even-length numbers (e.g., 1221): x will equal reversedHalf (12 == 12)
        // For odd-length numbers (e.g., 121): x will be 1, reversedHalf will be 12. 
        // We eliminate the middle digit by doing reversedHalf / 10.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
