public class LeetCode_5_100 {

    //方法一，使用动态规划
    public String longestPalindrome(String s) {
        //使用动态规划来实现
        //根据回串的定义我们可知，
        /**
         我们定义pand(i, j) = 0/1来确定其是否是回文串，0-不是，1-是
         如果pand(i, j) = 1的时候，那么pand(i + 1, j - 1) = 1,并且Si == Sj
         */
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int[][] pand = new int[n][n];
        for (int i = 0; i < n; i++) {
            pand[i][i] = 1;
        }
        String res = String.valueOf(s.charAt(0));
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)
                        && (i + 1 > j - 1 || pand[i + 1][j - 1] == 1)) {
                    pand[i][j] = 1;
                    if (j + 1 - i > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }

            }
        }
        return res;
    }

    //方法二：使用中心扩展
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //使用中心扩展算法
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
            
        }
        return s.substring(start, end + 1);
    }

    //扩展并返回扩展后的长度
    private int expand(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}