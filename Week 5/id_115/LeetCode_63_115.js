/*
 * @lc app=leetcode.cn id=63 lang=javascript
 *
 * [63] 不同路径 II
 */

// @lc code=start
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function (obstacleGrid) {
  if (obstacleGrid[0][0]) return 0
  obstacleGrid[0][0] = 1
  for (let i = 1; i < obstacleGrid.length; i++) {
    obstacleGrid[i][0] = obstacleGrid[i][0] ? 0 : obstacleGrid[i - 1][0]
  }

  for (let i = 1; i < obstacleGrid[0].length; i++) {
    obstacleGrid[0][i] = obstacleGrid[0][i] ? 0 : obstacleGrid[0][i - 1]
  }
  for (let i = 1; i < obstacleGrid.length; i++) {
    for (let j = 1; j < obstacleGrid[0].length; j++) {
      obstacleGrid[i][j] = obstacleGrid[i][j] ? 0 : (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1])
    }
  }
  return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1]
};
// @lc code=end

