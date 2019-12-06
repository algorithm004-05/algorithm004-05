import java.util.ArrayList;
import java.util.List;



/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        _generate( 0, 0, n, "");
        return result;
    }

    public void _generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            result.add(s);
            return ;
        }

        // process current logic: left, right
        
        // drill down
        if (left < n)
            _generate(left+1, right, n, s + "(");

        if (left > right)
            _generate(left, right + 1, n, s + ")");

        // reverse
    }



    
}
// @lc code=end

