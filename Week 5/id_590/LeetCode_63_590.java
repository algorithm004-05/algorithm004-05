package homework.week5;

//https://leetcode-cn.com/problems/unique-paths-ii/
public class LeetCode_63_590 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,
                n = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1){
            return 0;
        }else{
            obstacleGrid[0][0]=1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j!=0) {
                    if (obstacleGrid[i][j] != 1 && obstacleGrid[i][j-1] != 0){
                        obstacleGrid[i][j] = 1;
                    }else{
                        obstacleGrid[i][j]=0;
                    }
                }

                if (j == 0 && i != 0 ) {
                    if (obstacleGrid[i][j] != 1 && obstacleGrid[i-1][j]!=0){
                        obstacleGrid[i][j] = 1;
                    }else{
                        obstacleGrid[i][j]=0;
                    }
                }

                if (i != 0 && j != 0) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
