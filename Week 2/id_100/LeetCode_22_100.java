import java.util.*;
/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class LeetCode_22_100 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, "", ans);
        return ans;
    }

    private void generate(int left, int right, int n, String s, List<String> ans) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(", ans);
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")", ans);
        }
    }

}