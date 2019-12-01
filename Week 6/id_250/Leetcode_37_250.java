class Solution {
    final int N = 9;
    int[] row = new int [N], col = new int [N];
    int[] ones = new int[1 << N], map = new int[1 << N];
    int[][] cell = new int[3][3];
    public void solveSudoku(char[][] board) {
        init();
        int cnt = fill_state(board);
        dfs(cnt, board);
    }
    void init(){
        for(int i = 0; i < N; i++) row[i] = col[i] = (1 << N) - 1;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                cell[i][j] = (1 << N) - 1;
        for(int i = 0; i < N; i++) map[1 << i] = i;
        for(int i = 0; i < 1 << N; i++){
            int n = 0;
            for(int j = i; j != 0; j ^= lowBit(j)) n++;
            ones[i] = n;
        }
    }
    int fill_state(char[][] board){
        int cnt = 0;    //统计board数组空格('.')的个数
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    change_state(i, j, t);
                }else cnt++;
            }
        }
        return cnt;
    }
    boolean dfs(int cnt, char[][] board){
        if(cnt == 0) return true;
        int min = 10, x = 0, y = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == '.'){
                    int k = ones[get(i, j)];
                    if(k < min){
                        min = k;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        for(int i = get(x, y); i != 0; i ^= lowBit(i)){
            int t = map[lowBit(i)];

            change_state(x, y, t);
            board[x][y] = (char)('1' + t);

            if(dfs(cnt - 1, board)) return true;

            //恢复现场
            change_state(x, y, t);
            board[x][y] = '.';
        }
        return false;
    }
    void change_state(int x, int y, int t){
        row[x] ^= 1 << t;
        col[y] ^= 1 << t;
        cell[x / 3][y / 3] ^= 1 << t;
    }
    int get(int x, int y){
        return row[x] & col[y] & cell[x / 3][y / 3];
    }
    int lowBit(int x){
        return -x & x;
    }
}