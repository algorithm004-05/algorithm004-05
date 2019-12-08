package week5;

/**
 * @author shizeying
 * @date 2019/11/15 15:19
 * @description 63:不同路径II
 */
public class leetcode_63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }
    for (int i = obstacleGrid.length - 1; i >= 0; i--) {
      for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
        if (obstacleGrid[i][j] == 0) {
          if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
            continue;
          }
          int a = i + 1 < obstacleGrid.length ? obstacleGrid[i + 1][j] : 0;
          int b = j + 1 < obstacleGrid[i].length ? obstacleGrid[i][j + 1] : 0;
          obstacleGrid[i][j] = a + b;

        } else {
          obstacleGrid[i][j] = 0;
        }
      }
    }
    return obstacleGrid[0][0];
  }


}
