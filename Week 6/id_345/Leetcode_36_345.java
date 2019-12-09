package xyz.isok.algorithm.leetcode.medium;

public class No36ValidSudoku {

    public static void main(String[] args) {

//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        No36ValidSudoku validSudoku = new No36ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));


    }

    public boolean isValidSudoku(char[][] board) {
        Integer[][] rows = new Integer[9][9];
        Integer[][] cols = new Integer[9][9];
        Integer[][] blocks = new Integer[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int e = c - '0' - 1;
                    Integer cache = rows[i][e];
                    if (cache != null) {
                        return false;
                    }
                    rows[i][e] = e;

                    cache = cols[j][e];
                    if (cache != null) {
                        return false;
                    }
                    cols[j][e] = e;

                    int block = i / 3 * 3 + j / 3;
                    cache = blocks[block][e];
                    if (cache != null) {
                        return false;
                    }
                    blocks[block][e] = e;
                }
            }
        }
        return true;
    }

}
