package id_105;

public class LeetCode_79_105 {

    private boolean[][] marked;

    private int[][] direction = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1},
    };


    private int rows;

    private int cols;

    private String word;

    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) return false;

        cols = board[0].length;

        this.marked = new boolean[rows][cols];
        this.word = word;
        this.board = board;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(row, col, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(int row, int col, int start) {

        if (start == word.length() - 1){
            return board[row][col] == word.charAt(start);
        }

        if (board[row][col] == word.charAt(start)){
            marked[row][col] = true;

            for (int[] ints : direction) {
               int nx = row + ints[0];
               int ny = col + ints[1];
               if (!inArea(nx, ny) || marked[nx][ny]){
                   continue;
               }
                if (dfs(nx, ny, start + 1)){
                    return true;
                }
            }
            marked[row][col] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return !(x < 0 || x >= rows || y < 0 || y >= cols);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a','b'}
        };

        LeetCode_79_105 l = new LeetCode_79_105();

        System.out.println(l.exist(board, "ba"));


        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };

        System.out.println(l.exist(board2, "ABCCED"));
        System.out.println(l.exist(board2, "SEE"));
        System.out.println(l.exist(board2, "ABCD"));

    }
}
