//7.plus-one
    public static int[] plusOne(int[] digits) {
        boolean carry = true, overflow = false;
        int i = digits.length - 1;
        while (carry) {
            int k = digits[i] + 1;
            if (k == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] n = new int[digits.length + 1];
                    n[0] = 1;
                    System.arraycopy(digits, 0, n, 1, digits.length);
                    return n;
                }
            } else {
                digits[i]++;
                carry = false;
            }
            i--;
        }
        return digits;
    }
