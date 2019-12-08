//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 位运算 时间O(n!) 空间O(n)
class Solution {
    private int count;
    private int size;
    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return count;
    }
    private void dfs (int row, int pie, int na) {
        // 当row对应的bit位为1时表示被占用
        if (row == size) {
            count++;
            return;
        }
        // pos中为1的bit位表示可以使用
        int pos = (~(row | pie | na)) & size;
        while (pos != 0) {
            int p = pos & (- pos);
            pos = pos & (pos - 1);
            dfs(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
