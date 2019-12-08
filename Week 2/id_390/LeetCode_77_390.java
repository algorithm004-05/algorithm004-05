//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 回溯法
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        backtrack(1, n, k, new LinkedList<Integer>(), output);
        return output;
    }

    private void backtrack (int i, int n, int k, LinkedList<Integer> list, List<List<Integer>> output) {
        if (list.size() == k) {
            output.add(new LinkedList<Integer>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrack(j + 1, n, k, list, output);
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
