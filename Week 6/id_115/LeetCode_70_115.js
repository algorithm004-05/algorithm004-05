/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  if (n < 3) return n
  let f1 = 1,
    f2 = 2,
    f3 = 0
  let i = 0
  while (i < n) {
    f3 = f2 + f1
    f1 = f2
    f2 = f3
    i++
  }
  return f3
};

var climbStairs = function (n) {
  if (n < 3) return n
  if (n == 3) return 4
  let f1 = 1,
    f2 = 2,
    f3 = 4,
    f4 = 0
  let i = 4
  while (i <= n) {
    f4 = f3 + f2 + f1
    f1 = f2
    f2 = f3
    f3 = f4
    i++
  }
  return f4
};

var climbStairs = function (n) {
  if (n < 3) return 1
  if (n == 3) return 3
  let arr = []
  for (let i = 0; i <= n; i++) {
    arr[i] = []
    for (let j = 0; j <= n; j++) {
      arr[i][j] = 0
    }
  }
  arr[1][1] = 1
  arr[2][2] = 1
  arr[3][3] = 1
  arr[1][3] = 1
  arr[2][3] = 1

  for (let j = 4; j <= n; j++) {
    arr[1][j] = arr[2][j - 1] + arr[3][j - 1]
    arr[2][j] = arr[3][j - 1] + arr[1][j - 1]
    arr[3][j] = arr[1][j - 1] + arr[2][j - 1]
  }
  return arr[1][j] + arr[2][j] + arr[3][j]
};

// @lc code=end

