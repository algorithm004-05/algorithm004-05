/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0 ;
        int maxlen = 0;

        int dp[] = new int[s.length()];
        for (int i = 1 ; i < s.length() ;i++) {
            if (s.charAt(i) == ')' ) {
                    if (s.charAt(i-1) == '(') {
                        dp[i] = ((i>=2) ? dp[i-2] :0) +2;
                    }
                    else {
                        int index = i-dp[i-1] -1;
                        if(index >=0 && s.charAt(index)=='(') {
                            dp[i] = dp[i-1] + ((index +1  >=2) ? dp[index-1] : 0) + 2;
                        }
                    }
                    maxlen = Math.max(maxlen,dp[i]);

            }
        }
        return maxlen;
    }
}
// @lc code=end

