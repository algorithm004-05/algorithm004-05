/*
 * @lc app=leetcode.cn id=36 lang=javascript
 *
 * [36] 有效的数独
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
  let row = []
  let col = []
  let block = []
  for (let i = 0; i < board.length; i++) {
    row[i] = {}
    col[i] = {}
    block[i] = {}
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board.length; j++) {
      if (board[i][j] !== '.') {
        let num = board[i][j]
        if (!row[i][num]) {
          row[i][num] = 1
        } else {
          row[i][num]++
        }
        if (!col[j][num]) {
          col[j][num] = 1
        } else {
          col[j][num]++
        }
        let b_index = Math.floor((i / 3)) * 3 + Math.floor(j / 3)
        if (!block[b_index][num]) {
          block[b_index][num] = 1
        } else {
          block[b_index][num]++
        }
        if (row[i][num] > 1 || col[j][num] > 1 || block[b_index][num] > 1) return false
      }
    }
  }
  return true
};
// @lc code=end

