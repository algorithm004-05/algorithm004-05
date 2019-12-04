
class Solution {
    public int minPathSum(int[][] grid) {

		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j == grid[0].length - 1) {
					continue;
				} else if (i == grid.length - 1) {
					grid[i][j] = grid[i][j + 1] + grid[i][j];
				} else if (j == grid[0].length - 1) {
					grid[i][j] = grid[i + 1][j] + grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
				}
			}
		}

		return grid[0][0];
    }
}