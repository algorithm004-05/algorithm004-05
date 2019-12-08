/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  if (!grid) return 0
  if (!grid.length) return 0
  let res = 0
  function sink(x, y) {
    if (grid[x][y] == 0) return 0
    grid[x][y] = 0
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < dx.length; i++) {
      let a = x + dx[i]
      let b = y + dy[i]
      if (a >= 0 && a < grid.length && b >= 0 && b < grid[x].length) {
        if (grid[a][b] == 1) {
          sink(a, b)
        }
      }
    }
    return 1
  }
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      res += sink(i, j)
    }
  }
  return res
};
var numIslands = function (grid) {
  if (!grid) return 0
  if (!grid.length) return 0
  let res = 0
  let stack = []
  function sink(x, y) {
    if (grid[x][y] == 0) return 0
    grid[x][y] = 0
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < dx.length; i++) {
      let a = x + dx[i]
      let b = y + dy[i]
      if (a >= 0 && a < grid.length && b >= 0 && b < grid[x].length) {
        if (grid[a][b] == 1) {
          stack.push([a, b])
        }
      }
    }
    return 1
  }
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] == 1) {
        res++
        stack.push([i, j])
        while (stack.length) {
          let [x, y] = stack.shift()
          sink(x, y)
        }
      }
    }
  }
  return res
};
var numIslands = function (grid) {
  if (!grid.length) return 0
  let res = 0
  let p = new Array(grid.length * grid[0].length)
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] == 1) {
        p[i * grid[0].length + j] = -1
        res++
      } else {
        p[i * grid[0].length + j] = -2
      }
    }
  }
  function union(x, y) {
    let xSet = find(x)
    let ySet = find(y)
    if (xSet !== ySet) {
      p[xSet] = ySet
      res--
    }
  }
  function find(x) {
    let root = x
    while (-1 !== p[root]) {
      root = p[root]
    }
    while (-1 !== p[x]) {
      let temp = x
      x = p[x]
      p[temp] = root
    }
    return root
  }
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] == 1) {
        unionFun(i, j)
      }
    }
  }
  function unionFun(x, y) {
    grid[x][y] = 0
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < 4; i++) {
      let x_ = x + dx[i]
      let y_ = y + dy[i]
      if (x_ >= 0 && x_ < grid.length && y_ >= 0 && y_ < grid[x_].length && grid[x_][y_] == 1) {
        union(x * grid[x].length + y, x_ * grid[x_].length + y_)
      }
    }
  }
  return res
};
// @lc code=end

