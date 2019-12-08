class LeetCode_200_495 {

    public static void main(String[] args) {
        // char[][] grid = new char[][] {
        //   new char[] {'1','1','1','1','0'},
        //   new char[] {'1','1','0','1','0'},
        //   new char[] {'1','1','0','0','0'},
        //   new char[] {'0','0','0','0','0'},
        // };
        char[][] grid = new char[][] {
          new char[] {'1','1','0','0','0'},
          new char[] {'1','1','0','0','0'},
          new char[] {'0','0','1','0','0'},
          new char[] {'0','0','0','1','1'},
        };
        int result = new LeetCode_200_495().numIslands(grid);
        System.out.println(result);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1')
                    numIslands += dfs(grid, i, j);   // This is where we are calculating the number of islands
            }
        }

        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        // 1. row < 0
        // 2. row greater than grid.length
        // 3. column < 0
        // 4. column greater than grid.length
        // 5. if the position is a '0'
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;

        grid[i][j] = '0'; // chagne the visited land to water
        dfs(grid, i + 1, j); // up
        dfs(grid, i - 1, j); // down
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
        return 1;
    }
}
