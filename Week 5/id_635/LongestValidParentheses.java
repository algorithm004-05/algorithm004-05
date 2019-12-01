package com.simon.leetcode.w5.lcn32;

import java.util.Stack;

public class LongestValidParentheses {
    //思路1
    //1.当前为左括号时，后续可以为左括号和右括号，为空则无效
    //2.当前为右括号时，前面最近一个未匹配符号是左括号则有效，有效长度加2，否则无效，长度清空
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    //思路2：dp
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        //表示以第i个字符结尾最长有效长度
        int[] dp = new int[chars.length];
        int maxLen = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    int index = i - dp[i - 1] - 1;
                    if (index >= 0 && chars[index] == '(') {
                        dp[i] = (index - 1 >= 0 ? dp[index - 1] : 0) + dp[i - 1] + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
