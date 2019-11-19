import java.util.LinkedList;
import java.util.Queue;

/**
 *让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 
 * 'M' 代表一个未挖出的地雷，
 * 'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 *     数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 *     'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 *
 * 示例 1：
 *
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 * 示例 2：
 *
 * 输入:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 *  
 *
 * 注意：
 *
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_529_510 {

    public static void main(String[] args) {
        char[][] a = { { 'E', 'E', 'E', 'E', 'E' }, 
        { 'E', 'E', 'M', 'E', 'E' }, 
        { 'E', 'E', 'E', 'E', 'E' },
        { 'E', 'E', 'E', 'E', 'E' } };

        boolean f = (a[1][2] == 'M');
        new LeetCode_529_510().updateBoardB(a, new int[]{3,0});
        System.out.println("");

    }

    public char[][] updateBoard2(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2) return board;
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            dfs(board, x, y, m, n, dirs);
        }
        return board;
    }
    
    private void dfs(char[][] board, int x, int y, int m, int n, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int mine = adjMine(board, x, y, m, n);
        if (mine > 0) {
            board[x][y] = (char) ('0' + mine);
        } else {
            board[x][y] = 'B';
            for (int[] d : dirs) {
                dfs(board, x + d[0], y + d[1], m, n, dirs);
            }
        }
    }
    
    private int adjMine(char[][] board, int x, int y, int m, int n) {
        int cnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (0 <= i && i < m && 0 <= j && j < n && board[i][j] == 'M')
                    cnt++;
            }
        }
        return cnt;
    }

    public char[][] updateBoard1(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        
        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        }
        else { // Empty
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }
            
            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
            }
            else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }
        
        return board;
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        helper(board, click, dir);
        return board;
    }

    private void helper(char[][] board, int[] click, int[][] dir) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return;
        }
        board[click[0]][click[1]] = 'B';
        helper2(board, click, dir, "M");
        if (board[click[0]][click[1]] == 'B') {
            helper2(board, click, dir, "E");
        }
    }

    private void helper2(char[][] board, int[] click, int[][] dir, String flag) {
        int max = 0;
        int[] clickTemp = new int[2];
        for (int[] is1 : dir) {
            clickTemp[0] = click[0] + is1[0];
            clickTemp[1] = click[1] + is1[1];
            if (clickTemp[0] < 0 || clickTemp[1] < 0 || clickTemp[0] > (board.length - 1)
                    || clickTemp[1] > (board[clickTemp[0]].length - 1)) {
                continue;
            }

            if ("M".equals(flag) && board[clickTemp[0]][clickTemp[1]] == 'M'
                    || board[clickTemp[0]][clickTemp[1]] == 'X') {
                max++;
                board[click[0]][click[1]] = (char) (max + '0');
            } else if ("E".equals(flag) && board[clickTemp[0]][clickTemp[1]] == 'E') {
                helper(board, clickTemp, dir);
            }

        }

    }

    public char[][] updateBoardB(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            click = queue.poll();
            board[click[0]][click[1]] = 'B';
            int l = 0,max=0,r=0,t=0;
            for (int[] is1 : dir) {
                r = click[0] + is1[0];
                t = click[1] + is1[1];
                if (r < 0 || t < 0 || r > (board.length - 1)
                        || t > (board[r].length - 1)) {
                    continue;
                }

                if (board[r][t] == 'M'|| board[r][t] == 'X') {
                    max++;
                    board[click[0]][click[1]] = (char) (max + '0');
                } else if (board[r][t] == 'E') {
                    l++;
                    board[r][t] = 'B';
                    queue.offer(new int[]{r,t});
                }
            }

            if (board[click[0]][click[1]] != 'B') {
                for (int i = 1; i <= l; i++) {
                   int[] s = queue.removeLast();
                   board[s[0]][s[1]] = 'E';
                }
            }
        }
        return board;
    }


}
