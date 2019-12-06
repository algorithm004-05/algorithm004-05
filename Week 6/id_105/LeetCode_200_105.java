package id_105;

public class LeetCode_200_105 {

    private int[][] directions = {
            {-1, 0}, // up.
            {0, -1}, // left.
            {1, 0}, // down.
            {0, 1}, //right.
    };

    private boolean[][] marked;

    private int rows;

    private int cols;

    private char[][] grid;

    public int numIslands(char[][] grid) {

        rows = grid.length;

        if (rows == 0) return 0;

        cols = grid[0].length; //有n列。

        this.grid = grid;

        marked = new boolean[rows][cols];

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (!marked[i][j] && grid[i][j] == '1') {
                    count += 1;
//                    dfs(i, j);
                    mark(i, j);
                }
            }
        }
        return count;
    }

    private void mark(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') return;

        grid[i][j] = '0';

        mark(i - 1, j);
        mark(i + 1, j);
        mark(i, j - 1);
        mark(i, j + 1);

    }

    private void dfs(int i, int j) {

        marked[i][j] = true;

        for (int[] direction : directions) {
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            if (!inArea(new_i, new_j)
                    || grid[new_i][new_j] == '0'
                    || marked[new_i][new_j]) {
                continue;
            }
            dfs(new_i, new_j);
        }
    }

    private boolean inArea(int x, int y) {
        return !(x < 0 || x >= rows || y < 0 || y >= cols);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '1', '0'},
        };

        LeetCode_200_105 l = new LeetCode_200_105();
        System.out.println(l.numIslands(grid));
    }

}
