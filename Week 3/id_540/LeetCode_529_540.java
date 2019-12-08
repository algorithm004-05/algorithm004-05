package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_529_540 {
    public char[][] updateBoard(char[][] board, int[] click) {
        long startTime = System.currentTimeMillis();
        char c = board[click[0]][click[1]];

        // if it's mine (M), mark as X
        if (c == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        // if it's empty (E)
        if (c == 'E') {
            Queue<int[]> checkQueue = new LinkedList<>();
            checkQueue.add(click);

            while (!checkQueue.isEmpty()) {
                int[] checkPoint = checkQueue.remove();
                if (checkSurrounding(checkPoint[0], checkPoint[1], board, checkQueue)) {
                    return board;
                }
            }
        }

        return board;
    }

    private boolean checkSurrounding(int x, int y, char[][] board, Queue<int[]> checkQueue) {

        if (board[x][y] != 'E') {
            return true;
        }

        int mineCounter = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'M') {
                    mineCounter++;
                }
            }
        }

        if (mineCounter > 0) {
            board[x][y] = (char)(48 + mineCounter);
            return true;
        } else {
            board[x][y] = 'B';
            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                        checkQueue.add(new int[]{i, j});
                    }
                }
            }

            return false;
        }
    }
}
