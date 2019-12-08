/**
 * @param {character[][]} grid
 * @return {number}
 */
 // 推平岛屿并判断数量
var numIslands = function(grid) {
  if (!grid || !grid.length) return 0;
  
  var y = grid.length, x = grid[0].length, result = 0;
  var dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
  
  for (var i = 0; i < y; i++) {
      for (var j = 0; j < x; j++) {
          if (!(grid[i][j] === '1')) continue;
          
          result += getIslandNums(i, j);
      }
  }
  
  function getIslandNums (i, j) {
      if (!(grid[i][j] === '1')) return 0;
      
      grid[i][j] = '0';
      for (var k = 0; k < dx.length; k++) {
          var nextY = i + dy[k], nextX = j + dx[k];
          if (
              (nextX >= 0 && nextX < x && nextY >= 0 && nextY < y)
              && grid[nextY][nextX] === '1'
          ) getIslandNums(nextY, nextX);
      }
      
      return 1;
  }
  return result;
};