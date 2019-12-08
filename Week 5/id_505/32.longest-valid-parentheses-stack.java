/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (26.51%)
 * Likes:    2484
 * Dislikes: 110
 * Total Accepted:    229.1K
 * Total Submissions: 857.4K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */

// @lc code=start

class Solution {
    public int longestValidParentheses(String s) {
        char[] srs = s.toCharArray();

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int len = srs.length;
        stack.push(-1);
        for(int i = 0; i < len; i++) {
            if (srs[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max,i - stack.peek());
                } else {
                   stack.add(i);
                }
            }

        }
        
        return max;

    }

}
// @lc code=end

