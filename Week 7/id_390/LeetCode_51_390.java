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
// 2. 回溯法+位运算  时间O(n!) 空间O(n)
class Solution {
    private List<List<String>> result = new ArrayList<List<String>>();
    private int count;
    private int size;
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return result;
        }
        size = (1 << n) - 1;
        dfs(0, 0, 0, new ArrayList<Integer>());
        return result;
    }
    private void dfs (int row, int pie, int na, List<Integer> cur) {
        if (row == size) {
            result.add(change(cur));
            return;
        }
        int pos = size & (~(row | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            pos = pos & (pos - 1);
            cur.add((int)(Math.log(p)/Math.log(2)));
            dfs(row | p, (pie | p) << 1, (na | p) >> 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
    private List<String> change (List<Integer> cur) {
        List<String> res = new ArrayList<String>();
        for (int col : cur) {
            char[] c = new char[cur.size()];
            Arrays.fill(c, '.');
            c[col] = 'Q';
            res.add(String.valueOf(c));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
