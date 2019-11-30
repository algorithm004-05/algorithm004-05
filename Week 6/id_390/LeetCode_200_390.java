//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集



//leetcode submit region begin(Prohibit modification and deletion)
// 3. 并查集  时间O(N*M) 空间O(N*M)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        UnionFind union = new UnionFind(grid);
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union.union(i * nc + j, (i - 1) * nc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union.union(i * nc + j, i * nc + j - 1);
                    }
                    if (i + 1 < nr && grid[i + 1][j] == '1') {
                        union.union(i * nc + j, (i + 1) * nc + j);
                    }
                    if (j + 1 < nc && grid[i][j + 1] == '1') {
                        union.union(i * nc + j, i * nc + j + 1);
                    }
                }
            }
        }
        return union.getCount();
    }
}
class UnionFind {
    private int count = 0;
    private int[] parent;
    private int[] num;
    public UnionFind (char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        parent = new int[nr * nc];
        num = new int[nr * nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    parent[i * nc + j] = i * nc + j;
                    count++;
                }
                num[i * nc + j] = 0;
            }
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
            if (num[rootP] > num[rootQ]) {
                parent[rootQ] = rootP;
            } else if (num[rootP] < num[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                num[rootP]+=num[rootQ];
            }
            count--;
        }
    }
    public int getCount () {
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
