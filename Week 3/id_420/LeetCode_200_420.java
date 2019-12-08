package geekbang.myleetcode.week03;

/**
 * lesson09
 */
public class LeetCode_200_420 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        Solution solution = new LeetCode_200_420().new Solution();
        int len = solution.numIslands(grid);
        System.out.println("main:" + len);

    }

    class Solution {
        private int n;
        private int m;

        public int numIslands(char[][] grid) {
            n = grid.length;
            if (0 == n) {
                return 0;
            }
            m = grid[0].length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ('0' == grid[i][j]) {
                        continue;
                    }
                    sink(grid, i, j);
                    count ++;
                }
            }
            return count;
        }

        private void sink(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || '0' == grid[i][j]) {
                return;
            }
            grid[i][j] = '0';
            sink(grid, i + 1, j);
            sink(grid, i - 1, j);
            sink(grid, i, j + 1);
            sink(grid, i, j - 1);
        }
    }
}
