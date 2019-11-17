/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class LeetCode_200_100 {
    /**
     * 可以想象每个为1的结点，向四方扩散。到达边界或者0的位置停止即可。
     * 所以完全可以套用深度优先搜索
     * 时间复杂度：O(r*c)
     * 空间复杂度：整个压栈过程最坏情况下是O(r*c)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int landsNums = 0;
        int rLength = grid.length;
        int cLength = grid[0].length;
        for (int r = 0; r < rLength; r++) {
            for (int c = 0; c < cLength; c++) {
                if (grid[r][c] == '1') {
                    landsNums++;
                    dfs(grid, r, c, rLength, cLength);
                }
            }
        }
        return landsNums;
    }

    private void dfs(char[][] grid, int r, int c, int rLength, int cLength) {
        //return condition
        if (r < 0 
                || c < 0 
                || r >= rLength
                || c >= cLength
                || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c, rLength, cLength);
        dfs(grid, r - 1, c, rLength, cLength);
        dfs(grid, r, c + 1, rLength, cLength);
        dfs(grid, r, c - 1, rLength, cLength);
    }
}