//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 回溯法（剪枝） 时间O(n!) 空间O(n)
class Solution {
    private Set<Integer> cols = new HashSet<Integer>();
    private Set<Integer> pie = new HashSet<Integer>();
    private Set<Integer> na = new HashSet<Integer>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n < 1) {
            return result;
        }
        dfs(n, 0, new ArrayList(), result);
        return result;
    }

    private void dfs (int n, int row, List<Integer> cur, List<List<String>> result) {
        if (row >= n) {
            result.add(change(cur));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            cur.add(col);
            dfs(n, row + 1, cur, result);
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            cur.remove(cur.size() - 1);
        }
    }
    private List<String> change (List<Integer> list) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            char[] c = new char[list.size()];
            Arrays.fill(c, '.');
            c[list.get(i)] = 'Q';
            res.add(String.valueOf(c));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
