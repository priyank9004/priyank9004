class Solution {
    public int reverse(int x) {
        long reversed = 0; // Temporary storage to catch overflows safely
        
        while (x != 0) {
            int remainder = x % 10;       // Extract the last digit
            reversed = reversed * 10 + remainder; // Shift left and add digit
            x /= 10;                      // Chop off the last digit
        }
        
        // Check if the result overflows 32-bit signed integer limits
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) reversed;
    }
}
