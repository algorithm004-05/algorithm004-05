package xyz.isok.algorithm.leetcode.medium;

public class No200NumberOfIslands {

    private int high = 0;

    private int width = 0;

    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        this.high = grid.length;
        this.width = grid[0].length;
        this.grid = grid;
        boolean[][] marked = new boolean[high][width];
        int total = 0;

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                total = total + isIsland(i, j, marked);
            }
        }
        return total;
    }

    private int isIsland(int row, int col, boolean[][] marked) {
        if (row < 0 || col < 0 || row >= high || col >= width){
            return 0;
        }
        if (!marked[row][col]){
            if (grid[row][col] == '1'){
                marked[row][col] = true;
                isIsland(row + 1, col, marked);
                isIsland(row, col + 1, marked);
                isIsland(row - 1, col, marked);
                isIsland(row, col - 1, marked);
                return 1;
            }
        }
        return 0;
    }

}
