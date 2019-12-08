

import java.util.ArrayList;
import java.util.List;

/**
 *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_22_510 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_22_510().generateParenthesis1(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, n, "", list);
        return list;
    }

    /**
     * 递减
     * 
     * @param left
     * @param right
     * @param s
     * @param list
     */
    private void helper(int left, int right, String s, List list) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, s + "(", list);
        }

        if (right > left) {
            helper(left, right - 1, s + ")", list);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        helper(0, 0, n, "", list);
        return list;
    }

    /**
     * 递增
     * 
     * @param left
     * @param right
     * @param n
     * @param s
     * @param list
     */
    private void helper(int left, int right, int n, String s, List list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            helper(left + 1, right, n, s + "(", list);
        }

        if (right < left) {
            helper(left, right + 1, n, s + ")", list);
        }
    }
}
