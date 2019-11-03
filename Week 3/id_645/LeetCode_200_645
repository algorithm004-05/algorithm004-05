/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int islandsNumber = 0;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    char[][] tempGrid;

    public int numIslands(char[][] grid) {
        tempGrid = grid;
        for(int i = 0;i<tempGrid.length;i++){
            for(int j = 0;j<tempGrid[i].length;j++){
                if(tempGrid[i][j] == '0'){
                    continue;
                }
                islandsNumber += sinkIsland(i,j);
            }
        }
        return islandsNumber;
    }

    public int sinkIsland(int i,int j){
        if(tempGrid[i][j] == '0'){
            return 0;
        }
        tempGrid[i][j] = '0';
        for(int k =0;k<dx.length;k++){
            int x = i + dx[k];int y = j + dy[k];
            if(x<tempGrid.length && x>=0 && y>=0 && y<tempGrid[x].length){
                if(tempGrid[x][y] == '0'){
                    continue;
                }
                sinkIsland(x, y);
            }
        }
        return 1;
    }
}
// @lc code=end

