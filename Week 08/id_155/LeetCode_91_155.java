class Solution {
    public int numDecodings(String s) {
        return helper(0, s);
    }

    private int helper(int index, String s) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        int one = helper(index + 1, s);
        int two = 0;
        if (index < s.length() - 1 && (s.charAt(index) - '0' == 1 ||
                (s.charAt(index) - '0' == 2 && s.charAt(index + 1) - '0' < 7))) {
            two = helper(index + 2, s);
        }

        return one + two;
    }
}