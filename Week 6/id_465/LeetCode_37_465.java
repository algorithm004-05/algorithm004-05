package leetcode.jacf.tech;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    class Solution {
        // box size
        int n = 3;
        // row size
        int N = n * n;

        int[][] rows = new int[N][N + 1];
        int[][] columns = new int[N][N + 1];
        int[][] boxes = new int[N][N + 1];

        char[][] board;

        boolean sudokuSolved = false;

        public boolean couldPlace(int d, int row, int col) {
            // Check if one could place a number d in (row, col) cell
            int idx = (row / n) * n + col / n;
            return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
        }

        public void placeNumber(int d, int row, int col) {
            // Place a number d in (row, col) cell
            int idx = (row / n) * n + col / n;

            rows[row][d]++;
            columns[col][d]++;
            boxes[idx][d]++;
            board[row][col] = (char) (d + '0');
        }

        public void removeNumber(int d, int row, int col) {
            // Remove a number which didn't lead to a solution
            int idx = (row / n) * n + col / n;
            rows[row][d]--;
            columns[col][d]--;
            boxes[idx][d]--;
            board[row][col] = '.';
        }

        /**
         * Call backtrack function in recursion
         * to continue to place numbers
         * till the moment we have a solution
         */
        public void placeNextNumbers(int row, int col) {

            // if we're in the last cell
            // that means we have the solution
            if ((col == N - 1) && (row == N - 1)) {
                sudokuSolved = true;
            }
            // if not yet
            else {
                // if we're in the end of the row
                // go to the next row
                if (col == N - 1) {
                    backtrack(row + 1, 0);
                } else {
                    // go to the next column
                    backtrack(row, col + 1);
                }
            }
        }

        /**
         * Backtracking
         *
         * @param row
         * @param col
         */
        public void backtrack(int row, int col) {
            // if the cell is empty
            if (board[row][col] == '.') {
                // iterate over all numbers from 1 to 9
                for (int d = 1; d < 10; d++) {
                    if (couldPlace(d, row, col)) {
                        placeNumber(d, row, col);
                        placeNextNumbers(row, col);
                        // if sudoku is solved, there is no need to backtrack
                        // since the single unique solution is promised
                        if (!sudokuSolved) {
                            removeNumber(d, row, col);
                        }
                    }
                }
            } else {
                placeNextNumbers(row, col);
            }
        }

        public void solveSudoku(char[][] board) {
            this.board = board;

            // init rows, columns and boxes
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        int d = Character.getNumericValue(num);
                        placeNumber(d, i, j);
                    }
                }
            }
            backtrack(0, 0);
        }
    }

}
