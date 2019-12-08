/*
 * @lc app=leetcode.cn id=1091 lang=javascript
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function (grid) {
  if (!grid.length || grid[0][0] || grid[grid.length - 1][grid.length - 1]) return -1
  let res = 1
  let start = [[0, 0]]
  let visit = [1]
  while (start.length) {
    let len = start.length
    for (let i = 0; i < len; i++) {
      let [x, y] = start.shift()
      if (x == grid.length - 1 && y == grid.length - 1) return res
      let dx = [-1, 1, 0, 0, -1, 1, -1, 1]
      let dy = [0, 0, -1, 1, 1, -1, -1, 1]
      for (let j = 0; j < 8; j++) {
        let next_x = dx[j] + x
        let next_y = dy[j] + y
        if (next_x >= 0 && next_x < grid.length && next_y >= 0 && next_y < grid.length) {
          if (!visit[next_x * grid.length + next_y] && !grid[next_x][next_y]) {
            start.push([next_x, next_y])
            visit[next_x * grid.length + next_y] = 1
          }
        }
      }
    }
    res++
  }
  return -1
};
var shortestPathBinaryMatrix = function (grid) {
  if (!grid.length || grid[0][0] || grid[grid.length - 1][grid.length - 1]) return -1
  let res = 1
  let start = [[0, 0]]
  let end = [[grid.length - 1, grid.length - 1]]
  let visit = new Array(grid.length * grid.length)
  let visit2 = new Array(grid.length * grid.length)
  visit[0] = 1
  visit2[grid.length * grid.length - 1] = 1
  while (start.length && end.length) {
    let len = start.length
    for (let i = 0; i < len; i++) {
      let [x, y] = start[0]
      for (let j = 0; j < end.length; j++) {
        if (end[j][0] == x && end[j][1] == y) {
          return res
        }
      }
      start.shift()
      let dx = [-1, 1, 0, 0, -1, 1, -1, 1]
      let dy = [0, 0, -1, 1, 1, -1, -1, 1]
      for (let j = 0; j < 8; j++) {
        let next_x = dx[j] + x
        let next_y = dy[j] + y
        if (next_x >= 0 && next_x < grid.length && next_y >= 0 && next_y < grid.length) {
          if (!visit[next_x * grid.length + next_y] && !grid[next_x][next_y]) {
            start.push([next_x, next_y])
            visit[next_x * grid.length + next_y] = 1
          }
        }
      }
    }
    if (start.length >= end.length) {
      [start, end] = [end, start]
      let temp = [].concat(visit)
      visit = visit2
      visit2 = temp
    }
    res++
  }
  return -1
};
console.log(shortestPathBinaryMatrix([[0, 1], [1, 0]]))
// @lc code=end

