package leetcode.editor.cn;//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.List;

public class Leetcode_22_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_22_480().new Solution();
        List<String> strings = solution.generateParenthesis(2);
        System.out.println(strings);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void generate(String item, int left, int right, List res) {
            //左括号和右括号满足上述条件的前提下都为n个，添加这个答案
            if (left == 0 && right == 0) {
                res.add(item);
                return;
            }
            //左括号的个数小于n 才能继续放左括号
            if (left > 0) {
                generate(item + "(", left - 1, right, res);
            }
            //左括号个数必须大于右括号的放置个数 才能继续放右括号
            if (left < right) {
                generate(item + ")", left, right - 1, res);
            }
        }

        public List<String> generateParenthesis(int n) {
            /**
             *左括号个数必须大于右括号的放置个数 才能继续放右括号
             *左括号的个数小于n 才能继续放左括号
             *左括号和右括号满足上述条件的前提下都为n个，添加这个答案
             */
            List<String> res = new ArrayList<>();
            generate("", n, n, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}