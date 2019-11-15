package com.simon.leetcode.lcn529;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        return click(board, click[0], click[1]);
    }

    private char[][] click(char[][] board, int x, int y) {
        int num = getNum(board, x, y);
        if (num == 0) {
            board[x][y] = 'B';
        } else {
            board[x][y] = Character.forDigit(num, 10);
            return board;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < board.length && y + j >= 0 && y + j < board[0].length && board[x + i][y + j] == 'E') {
                    board = click(board, x + i, y + j);
                }
            }
        }
        return board;
    }

    private int getNum(char[][] board, int x, int y) {
        int num = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < board.length && y + j >= 0 && y + j < board[0].length && board[x + i][y + j] == 'M') {
                    num++;
                }
            }
        }
        return num;
    }

}
