class Solution {
    public int longestValidParentheses(String s) {

        int maxans = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {

            // 当 i 为 ")" 时，开始进行判断(只有当以 ")" 为结尾，才能够有效)
            if (s.charAt(i) == ')') {
                
                if (s.charAt(i - 1) == '(') {
                    // 防止数组溢出
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 看与dp数组当前记录的有效括号，之前的括号能否组成有效结果
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
} 
