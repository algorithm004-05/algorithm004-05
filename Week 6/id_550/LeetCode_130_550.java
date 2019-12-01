public class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if(n <= 2) {
            return;
        }
        
        int m = board[0].length;
        if(m <= 2){
            return;
        }
        for(int i = 0; i < n; i++){
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        
        for(int i = 1; i < m - 1; i++){
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                
                if(board[i][j] == '+'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int x, int y){
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        if(isValid(board, x, y)){
            //System.out.println(x + "," + y);
            q.offer(new Pair(x, y));
            board[x][y] = '+';
        }
        
        
        int[][] next = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            for(int i = 0; i < next.length; i++){
                int nextX = pair.x + next[i][0];
                int nextY = pair.y + next[i][1];
                if(isValid(board, nextX, nextY)){
                    //System.out.println(nextX + "," + nextY);
                    q.offer(new Pair(nextX, nextY));
                    board[nextX][nextY] = '+';
                }
            }
        }
        
    }
    
    private boolean isValid(char[][] board, int x, int y){
        int n = board.length;
        int m = board[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O'){
            return false;
        }
        
        return true;
    }
    
    class Pair{
        int x;
        int y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
