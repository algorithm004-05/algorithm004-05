package week5.Question32LongestValidParentheses;

import java.util.Stack;

/**
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
 **/
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(longestValidParenthesesII(s));
    }

    /**
     * 1.暴力算法。
     * 考虑s中每种可能的非空偶数长度子字符串，检查它是否是一个有效括号字符串序列。
     * 使用栈这种数据结构
     * 1.每遇到一个‘(’,将其放在栈顶。
     * 2.每遇到一个')'，从栈中弹出一个"("
     * 3.如果栈顶没有‘（’，或者遍历完整个子字符串后栈不为空，则该字符串是无效的。
     * 4.对每个偶数长度的子字符串都进行判断，保存找到的最长的有效子字符串的长度。
     * <p>
     * 复杂度分析：时间复杂度O（n^2）
     * 空间复杂度：O（n）。子字符串的长度最多会需要一个深度为n的栈。
     **/
    private static int longestValidParentheses(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 2.动态规划
     * 1.定义一个dp数组，其中第i个元素表示以下标为i的字符结尾的最长有效子字符串的长度。
     * 2.dp数组全部初始化为0；
     * 3.有效的子字符串一定以‘）’结尾 ==>以‘（’结尾的子字符串对应的dp数组位置上的值必定为0 ==>更新‘）’在dp数组中对应位置的值
     * <p>
     * dp方程：
     * 1.    s[i]=‘)’ 且 s[i - 1] =‘(’ ，也就是字符串形如"……()"，我们可以推出：
     * dp[i]=dp[i−2]+2
     * 因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。
     * <p>
     * 2.    s[i] = ‘) 且 s[i−1]=‘)’，也就是字符串形如 ‘‘.......))" ，可以推出：
     * 如果 s[i - dp[i - 1] - 1] = ‘(’ ，那么
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     * 这背后的原因是如果倒数第二个 ‘)’ 是一个有效子字符串的一部分（记为 sub_s），
     * 对于最后一个‘)’ ，如果它是一个更长子字符串的一部分，那么它一定有一个对应的 ‘(’，它的位置在倒数第二个 ‘)’
     * 所在的有效子字符串的前面（也就是 sub_s的前面）。
     * 因此，如果子字符串 sub_s的前面恰好是 ‘(’ ，那么我们就用 2加上 sub_s的长度（dp[i−1]）去更新 dp[i]。
     * 除此以外，我们也会把有效子字符串 ‘‘(,subs,)"之前的有效子字符串的长度也加上，也就是加上 dp[i−dp[i−1]−2] 。
     **/
    private static int longestValidParenthesesII(String s) {
        int maxLength = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //如果当前字符是‘）’子串长度才有可能是最长括号匹配长度
                if( s.charAt(i - 1) == '('){
                    //当前一个字符是‘（’,按照dp[i]=dp[i−2]+2计算
                    dp[i] = ((i - 2 >= 0) ? dp[i - 2] : 0) + 2;
                }
                if (i-dp[i-1]>0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    //当sub_s的前一个字符是‘（’时，按照 dp[i] = dp[i - 1] + dp[temp] + 2计算;
                    int temp  = (i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + temp + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}


























