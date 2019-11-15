/**
 * created by lchen on 2019/11/3
 */
public class LeetCode_200_535 {
    public static void main(String[] args) {

        Solution22 solution21 = new Solution22();
        System.out.println(solution21.numIslands(new char[][]{}));
    }

}
class Solution22 {
    

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < nr; ++i) {
            for (int j = 0; j < nc; ++j) {
                if (grid[i][j] == '1') {
                    ++num_islands;
                    dfs(grid, i, j);
                }
            }
        }

        return num_islands;
    }

    void dfs(char[][] chars, int i, int j) {
        if (i < 0 || j < 0 || i >= chars.length || j >= chars[0].length || chars[i][j] == '0') {
            return;
        }
        chars[i][j] = '0';
        dfs(chars, i - 1, j);
        dfs(chars, i + 1, j);
        dfs(chars, i, j - 1);
        dfs(chars, i, j + 1);
    }
}
