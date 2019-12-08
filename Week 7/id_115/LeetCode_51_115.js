/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
  if (n == 0) return []
  let col = {}
  let master = {}
  let slave = {}
  let res = []
  function helper(row, stack) {
    if (row == n) {
      res.push(proRes(stack))
      return
    }
    for (let i = 0; i < n; i++) {
      if (!col[i] && !master[row + i] && !slave[row - i]) {
        stack.push(i)
        col[i] = true
        master[row + i] = true
        slave[row - i] = true
        helper(row + 1, stack)
        stack.pop()
        col[i] = false
        master[row + i] = false
        slave[row - i] = false
      }
    }
  }
  function proRes(stack) {
    let arr = []
    for (let i = 0; i < n; i++) {
      let str = []
      for (let j = 0; j < n; j++) {
        if (stack[i] === j) {
          str.push('Q')
        } else {
          str.push('.')
        }
      }
      arr.push(str.join(""))
    }
    return arr
  }

  helper(0, [])
  return res
};
// @lc code=end

