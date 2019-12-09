class LeetCode_130_495 {
    boolean[][] flag;   //flag[i][j]为false，表示board[i][j]赋值为'X'
    int[] vi = {-1, 0, 1, 0};
    int[] vj = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length;
        //小于3行或3列直接返回
        if(n < 3) return;
        int m = board[0].length;
        if(m < 3) return;
        flag = new boolean[n][m];
        int i = 0, j = 0, a = 0, b = 0, d = 1;
        int total = 2 * (m + n) - 4;  //矩阵的4条边上的元素个数
        for(int k = 1; k <= total; k++){
            if(board[i][j] == 'O')  //只要发现矩阵的边上的元素为'O',那么与此'O'相接的所以'O'都不被改变
                dfs(i, j, n, m, board);
            a = i + vi[d];
            b = j + vj[d];
            if(a >= n || a < 0 || b >= m || b < 0){
                d = (d + 1) % 4;
                a = i + vi[d];
                b = j + vj[d];
            }
            i = a;
            j = b;
        }
        for(int p = 0; p < n; p++)
            for(int q = 0; q < m; q++){
                if(!flag[p][q])
                    board[p][q] = 'X';
            }
    }
    void dfs(int i, int j, int n, int m, char[][] board){
        flag[i][j] = true;
        for(int k = 0; k < 4; k++){
            int a = i + vi[k], b = j + vj[k];
            //只有a,b不越界，并且a,b在board数组为'O',而且a,b没走过(即flag[a][b] == false，不然会死循环)
            if(a >= 0 && a < n && b >= 0 && b < m && board[a][b] == 'O' && flag[a][b] == false)
                dfs(a, b, n, m, board);
        }
    }
}
