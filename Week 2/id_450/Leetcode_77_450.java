/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 *      输入: n = 4, k = 2
 *      输出:
 *           [
 *              [2,4],
 *              [3,4],
 *              [2,3],
 *              [1,2],
 *              [1,3],
 *              [1,4],
 *           ]
 */

public class Leetcode_77_450 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(int i, int n, int k, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j <= n; j++) {
            tmp.add(j);
            backtrack(j + 1, n, k - 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}