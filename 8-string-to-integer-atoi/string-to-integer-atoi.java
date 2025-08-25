class Solution {
    public int myAtoi(String s) {
        // 1. Trim whitespace
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // 2. Determine sign
        int index = 0;
        int sign = 1;
        if (s.charAt(0) == '+') {
            index++;
        } else if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        }

        // 3. Convert digits and handle overflow
        long result = 0; // Use long to detect overflow
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;

            // FINAL STEP: Check for overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        // 4. Return final result
        return (int) (result * sign);
    }
}