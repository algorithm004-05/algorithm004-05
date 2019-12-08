/**
 * Created by panda on 2019/12/8.
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_32_430 {
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            if (n == 0 || n == 1) {
                return 0;
            }
            int dp[] = new int[n];
            int max = 0;
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                char cur = s.charAt(i);
                if (cur == ')') {
                    char pre = s.charAt(i - 1);
                    if (pre == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 还要加上前面的一段
                        dp[i] = 2 + (i - 1 >= 0 ? dp[i - 1] : 0) + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                } else {
                    dp[i] = 0;
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
