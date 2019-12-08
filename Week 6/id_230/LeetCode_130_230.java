//===================================================================================================
//自己是想把边界的O，换成特殊的字符，
//然后遍历，相邻字符为特殊字符的，就都变成特殊字符，
//最后再把特殊字符换成O
//可是自己实现自己的思路存在障碍，没有实现。
//===================================================================================================
public static void dfs(char[][] grid, int i, int j) {
        //terminator
        if (i < 0 || j < 0 || i >= grid[0].length || j >= grid[0].length || grid[i][j] == 'X' || grid[i][j] == '@')
            return;
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            grid[i][j] = '#';
        } else{
            grid[i][j] = '@';
        }

        //process current logic
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid, x, y);
        }
        System.out.println("==================");
        for (char[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
        //dirll down
        //reverse
//        for (int k = 0; k < 4; k++) {
//            int x = i + dx[k];
//            int y = j + dy[k];
//            if ((x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length)){
//                if (grid[x][y] == '#') grid[i][j] = '#';
//            }
//        }
    }
//===================================================================================================
附上题解：
1，题解可以做出修改，比如添加两个数组，表示位置变换，一个for循环即可替代四个if语句
//===================================================================================================
public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(board, x, y);
//            dfs(board, i - 1, j); // 上
//            dfs(board, i + 1, j); // 下
//            dfs(board, i, j - 1); // 左
//            dfs(board, i, j + 1); // 右
        }
    }
