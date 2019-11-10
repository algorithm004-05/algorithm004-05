/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    //方便遍历八个点而准备的数组
    int[] pos1 = new int[]{1, -1, 1, 1, -1, -1, 0, 0};
    int[] pos2 = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    int y = 0;
    int x = 0;
    public char[][] updateBoard(char[][] board, int[] click) {
        y = board.length;
        x = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }
    //dfs
    public void dfs(char[][] board, int cur1, int cur2){
        //如果是炸弹，就结束
        if(board[cur1][cur2] == 'M'){
            board[cur1][cur2] = 'X';
            return;
        }
        //若点击的是E
        if(board[cur1][cur2] == 'E'){
            //计算当前位置周围的炸弹
            int count = countor(board, cur1, cur2);
            //为零修改为B 并且只要B才能继续递归 否则仅标记Count数值就结束递归
            if(count == 0){
                board[cur1][cur2] = 'B';
                
                for(int i = 0; i < 8; i++){
                    int temp1 = cur1 + pos1[i];
                    int temp2 = cur2 + pos2[i];
                    if(temp1 < 0 || temp1 >= y || temp2 < 0 || temp2 >= x){
                        continue;
                    }
                    if(board[temp1][temp2] == 'E'){
                        dfs(board, temp1, temp2);
                    }
                }
            }else{
                board[cur1][cur2] = (char)(count + '0');
            }
            
        }
    }
    //用来计算当前位置周围八个点的情况
    public int countor(char[][] board, int cur1, int cur2){
        int count = 0;
        for(int i = 0; i < 8; i++){
            int temp1 = cur1 + pos1[i];
            int temp2 = cur2 + pos2[i];
            if(temp1 < 0 || temp1 >= y || temp2 < 0 || temp2 >= x){
                continue;
            }
            if(board[temp1][temp2] == 'M'){
                count ++;
            }
        }
        return count;
    }
}

// @lc code=end

