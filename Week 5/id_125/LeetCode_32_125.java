import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.17 16:14
 * @Description:
 */
public class A32 {
    public static void main(String[] args) {

        A32 a32 = new A32();

        String s = "((()()()(()()()()()))";

        System.out.println(a32.longestValidParentheses(s));
    }

    /**
     * 倒着推
     * s[i] 为 (，则一定不能组成括号
     * 当s[i] 为 )
     * 存在：s[i-1] 为 (，可以组成值 + 2
     * s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，
     * 则dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
