class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to handle Integer.MIN_VALUE safely
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        // Subtract shifted divisors from the dividend
        while (dvd >= dvs) {
            long tempDvs = dvs, multiple = 1;
            while (dvd >= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }
            dvd -= tempDvs;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}
