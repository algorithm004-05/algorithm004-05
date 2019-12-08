package xyz.isok.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 1. 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 2. 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 3. 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 4. 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 */
public class No529MineSweeper {

    /**
     * 'M' 代表一个未挖出的地雷
     */
    private char m = 'M';

    /**
     * 'E' 代表一个未挖出的空方块
     */
    private char e = 'E';

    /**
     * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻
     */
    private char b = 'B';

    /**
     * 'X' 则表示一个已挖出的地雷
     */
    private char x = 'X';

    private int high = 0;

    private int width = 0;

    private char[][] board;

    private boolean[][] used;

    private Stack<Position> stack = new Stack<>();

    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length < 2){
            return null;
        }
        if (board.length <= 0 || board[0].length <= 0) {
            return null;
        }
        int posX = click[0], posY = click[1];
        high = board.length;
        width = board[0].length;
        this.board = board;
        used = new boolean[high][width];
        click(posX, posY);
        return board;
    }

    private void click(int posX, int posY) {
        if (posX < 0 || posX >= high || posY < 0 || posY > width){
            return;
        }
        if (m == board[posX][posY]){
            board[posX][posY] = x;
            return;
        }
        stack.push(new Position(posX, posY));
        growup();
    }

    private void growup() {
        while (stack.size() > 0){
            Position position = stack.pop();
            int posX = position.x;
            int posY = position.y;
            if (posX < 0 || posX >= high || posY < 0 || posY >= width){
                continue;
            }
            List<Position> list = new ArrayList<>();
            int total = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0){
                        continue;
                    }
                    int mark = bung(posX + i, posY + j);
                    if (mark == 0){
                        list.add(new Position(posX + i, posY + j));
                    }
                    total += mark;
                }
            }
            if (total == 0){
                board[posX][posY] = b;
                used[posX][posY] = true;
                for (Position pos : list) {
                    if (isValid(pos)){
                        stack.push(pos);
                    }
                }
            }else {
                board[posX][posY] = (char)(total + '0');
            }
        }
    }

    private int bung(int posX, int posY){
        return (posX < 0 || posX >= high || posY < 0 || posY >= width) ? 0 : m == board[posX][posY] ? 1 : 0;
    }

    private boolean isValid(Position pos){
        return !(pos.x < 0 || pos.x >= high || pos.y < 0 || pos.y >= width) && !used[pos.x][pos.y];
    }

    static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
