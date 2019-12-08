//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(0, 0, "", n, result);
        return result;
    }
    private void helper (int left, int right, String str, int MAX, List<String> result) {
        if (left >= MAX && right >= MAX) {
            result.add(str);
            return;
        }
        if (left < MAX) {
            helper(left + 1, right, str + "(", MAX, result);
        }
        if (right < left && right < MAX) {
            helper(left, right + 1, str + ")", MAX, result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
