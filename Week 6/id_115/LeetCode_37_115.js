/*
 * @lc app=leetcode.cn id=37 lang=javascript
 *
 * [37] 解数独
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function (board) {
  function isValidate(row, col, num) {
    for (let i = 0; i < 9; i++) {
      let boxRow = parseInt(row / 3) * 3;
      let boxCol = parseInt(col / 3) * 3;
      if (board[row][i] == num || board[i][col] == num || board[boxRow + parseInt(i / 3)][boxCol + i % 3] == num) {
        return false
      }
    }
    return true
  }
  function solve(board) {
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          for (let num = 1; num <= 9; num++) {
            if (isValidate(i, j, num)) {
              board[i][j] = `${num}`
              if (solve(board)) {
                return true
              }
              board[i][j] = '.'
            }
          }
          return false
        }
      }
    }
    return true
  }
  solve(board)
};
// @lc code=end

