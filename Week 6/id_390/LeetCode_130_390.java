//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int nr = board.length;
        int nc = board[0].length;
        UnionFind un = new UnionFind(nr * nc + 1);
        int virtualNode = nr * nc;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == nr - 1 || j == nc - 1) {
                        un.union(i * nc + j, virtualNode);
                    } else {
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                            un.union(i * nc + j, (i - 1) * nc + j);
                        }
                        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                            un.union(i * nc + j, i * nc + j - 1);
                        }
                        if (i + 1 < nr && board[i + 1][j] == 'O') {
                            un.union(i * nc + j, (i + 1) * nc + j);
                        }
                        if (j + 1 < nc && board[i][j + 1] == 'O') {
                            un.union(i * nc + j, i * nc + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O' && !un.isConnected(i * nc + j, virtualNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
class UnionFind {
    private int[] parent;
    public UnionFind (int capcity) {
        parent = new int[capcity];
        for (int i = 0; i < capcity; i++) {
            parent[i] = i;
        }
    }
    public int find (int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootQ] = rootP;
        }
    }
    public boolean isConnected (int p, int q) {
        return find(p) == find(q);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
