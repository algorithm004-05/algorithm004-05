import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        //方法一，动态规划，根据"结尾一定是右括号"这个规律推导
        // int maxlength = 0;
        // //dp[i]表示以下标i结尾的最长有效子字符串的长度
        // int[] dp = new int[s.length()];
        // for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == ')') {
        //         if (s.charAt(i-1) == '(') {
        //             dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
        //         } else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
        //             dp[i] = dp[i-1] + (i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2] : 0) +2;
        //         }
        //         maxlength = Math.max(maxlength, dp[i]);
        //     }
        // }
        // return maxlength;

        // //方法二，用栈，代码简单
        // //循环一般字符串，碰到左括号就将其index压入栈，碰到右括号就让当前栈poll
        // //且maxans就是当前遍历下标减去当前栈顶的下标
            int maxlength = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                int templen = 0;
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    //如果当前栈已经为空，则依然要保存当前下标值，用于后面计算
                    //每次遍历，栈都必须要有操作
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        templen = i - stack.peek();
                        maxlength = Math.max(templen, maxlength);
                    }
                }
            }
            return maxlength;


            // //方法三，使用left和right两个指针，来回扫描两次，可以让空间复杂度为O(1)
            // int left = 0, right = 0, maxlength = 0;
            // for (int i = 0; i < s.length(); i++) {
            //     if (s.charAt(i) == '(') {
            //         left++;
            //     } else {
            //         right++;
            //     }
            //     if (left == right) {
            //         maxlength = Math.max(maxlength, 2*right);
            //     } else if (right >= left) {
            //         left = right = 0;
            //     }
            // }
            // left = right = 0;
            // for (int i = s.length() - 1; i >= 0; i--) {
            //     if (s.charAt(i) == '(') {
            //         left++;
            //     } else {
            //         right++;
            //     }
            //     if (left == right) {
            //         maxlength = Math.max(maxlength, 2*left);
            //     } else if (left >= right) {
            //         left = right = 0;
            //     }
            // }
            // return maxlength;
    }
}
// @lc code=end

