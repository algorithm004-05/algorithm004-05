import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by panda on 2019/11/17.
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
 */
public class LeetCode_32_430 {
    /**
     * 动态规划
     */
    class Solution1 {
        public int longestValidParentheses(String s) {
            int max = 0;
            int n = s.length();
            if (n < 2) {
                return 0;
            }
            // 第i个元素作为结尾的最长有效字符串的长度
            int[] dp = new int[s.length()];
            for (int i = 1; i < n; i++) {
                // 最长有效字符串一定以右括号作为结尾
                if (s.charAt(i) == ')') {
                    // 前一个括号是左括号，直接匹配
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                        // 前一个括号是右括号
                    } else if (s.charAt(i - 1) == ')'
                            // 防止越界
                            && i - dp[i - 1] - 1 >= 0
                            // 和上一个最长有效字符串之前的括号匹配
                            && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 前一个最长有效字符串长度，加上匹配上的长度2，加上i-dp[i-1]-2结尾的有效字符串长度，要防止数组越界
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    // 更新最大值
                    max = Math.max(dp[i], max);
                }
            }
            return max;

        }
    }

    /**
     * 栈
     */
    class Solution2 {
        public int longestValidParentheses(String s) {
            int n = s.length();
            int max = 0;
            Deque<Integer> stack = new ArrayDeque(n);
            // 计算第一串匹配的括号对长度用，作为上一个已匹配完成的右括号序号
            stack.push(-1);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ')') {
                    // 弹出左括号（或上次剩余的右括号）
                    stack.removeFirst();
                    // 无右括号剩余（上次剩余右括号已弹出，无可匹配的左括号）
                    if (stack.isEmpty()) {
                        // 更新最近剩余右括号序号为本括号序号
                        stack.addFirst(i);
                        // 剩余的一定是上次剩余右括号序号
                    } else {
                        // 当前右括号与上一个右括号序号相减，为这个区间的最大字符串长度
                        max = Math.max(max, i - stack.getFirst());
                    }
                } else {
                    stack.addFirst(i);
                }
            }
            return max;
        }
    }


}
