package leetcode.jacf.tech;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author jacf
 */
public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur + "(", open + 1, close, max);
            if (close < open)
                backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

}
