/*
 * @lc app=leetcode.cn id=130 lang=javascript
 *
 * [130] 被围绕的区域
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function (board) {
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
        if (board[i][j] == 'O') {
          dfs(i, j)
        }
      }
    }
  }
  function dfs(x, y) {
    board[x][y] = '#'
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < 4; i++) {
      let x_ = x + dx[i]
      let y_ = y + dy[i]
      if (x_ >= 0 && x_ < board.length && y_ >= 0 && y_ < board[x_].length && board[x_][y_] == 'O') {
        dfs(x_, y_)
      }
    }
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] == '#') {
        board[i][j] = 'O'
      } else if (board[i][j] == 'O') {
        board[i][j] = 'X'
      }
    }
  }
};
var solve = function (board) {
  let stack = []
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
        if (board[i][j] == 'O') {
          stack.push([i, j])
        }
      }
    }
  }
  while (stack.length) {
    let [x, y] = stack.pop()
    board[x][y] = '#'
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < 4; i++) {
      let x_ = x + dx[i]
      let y_ = y + dy[i]
      if (x_ >= 0 && x_ < board.length && y_ >= 0 && y_ < board[x_].length && board[x_][y_] == 'O') {
        stack.push([x_, y_])
      }
    }
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] == '#') {
        board[i][j] = 'O'
      } else if (board[i][j] == 'O') {
        board[i][j] = 'X'
      }
    }
  }
};
var solve = function (board) {
  if (!board.length) return 0
  let p = new Array(board.length * board[0].length + 1)
  for (let i = 0; i <= board.length * board[0].length; i++) {
    p[i] = i
  }
  function union(x, y) {
    let px = find(x)
    let py = find(y)
    if (px !== py) {
      p[px] = py
    }
  }
  function find(x) {
    let root = x
    while (root !== p[root]) {
      root = p[root]
    }
    while (x !== p[x]) {
      let temp = x
      x = p[x]
      p[temp] = root
    }
    return root
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
        if (board[i][j] == 'O') {
          union(i * board[i].length + j, board.length * board[i].length)
        }
      } else {
        if (board[i][j] == 'O') {
          let rows = board.length
          let cols = board[i].length
          if (i > 0 && board[i - 1][j] == 'O')
            union(i * cols + j, (i - 1) * cols + j)
          if (i < rows - 1 && board[i + 1][j] == 'O')
            union(i * cols + j, (i + 1) * cols + j)
          if (j > 0 && board[i][j - 1] == 'O')
            union(i * cols + j, i * cols + j - 1)
          if (j < cols - 1 && board[i][j + 1] == 'O')
            union(i * cols + j, i * cols + j + 1)
        }
      }
    }
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] == 'O') {
        if (find(board.length * board[i].length) !== find(i * board[i].length + j)) {
          board[i][j] = 'X'
        }
      }
    }
  }
};
// @lc code=end

