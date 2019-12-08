//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)

// 这是我理解错题目的做法。
// "()(())" 预期结果是 6，而我只会输出 2。我以为只有连续的 () 才算，(()) 不算。

/*class Solution {
    public int longestValidParentheses(String s) {
        int tempCount = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ("(".equals(c + "")) {
                if (tempCount % 2 == 0) {
                    tempCount++;
                } else {
                    if (tempCount % 2 == 1) {
                        tempCount = 1;
                    }
                }
            }

            if (")".equals(c + "") && tempCount > 0) {
                if (tempCount % 2 == 1) {
                    tempCount++;
                } else {
                    if (tempCount > count) {
                        count = tempCount;
                    }
                    tempCount = 0;
                }

            }

        }

        if (count == 0 && tempCount % 2 == 0 && count < tempCount) {
            count = tempCount;
        }

        return count;

    }
}*/

// 国际站的 Most Voted 解法：
/*public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }
}*/

// 官方的 DP 解法：
/*
*
*
*
* */
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
