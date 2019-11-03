//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//例如，给出 n = 3，生成结果为：
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/generate-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_295 {

//    class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return res;
    }

    // left 随时加，不超标
    // right 前必须有 left， left > right
    private void _generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        // process current level logic : left, right

        // drill down
        if (left < n)
            _generate(left + 1, right, n, s + "(");
        if (right < left)
            _generate(left, right + 1, n, s + ")");

        // reverse states
    }

    public static void main(String[] args) {
        LeetCode_22_295 solution = new LeetCode_22_295();
        System.out.println(solution.generateParenthesis(3));
    }
//    }

}

