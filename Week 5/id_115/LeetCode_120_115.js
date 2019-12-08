/*
 * @lc app=leetcode.cn id=120 lang=javascript
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
  if (!triangle.length) return null
  if (triangle.length == 1) return Math.min([...triangle])
  for (let i = triangle.length - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1])
    }
  }
  return triangle[0][0]
};

var minimumTotal = function (triangle) {
  if (!triangle.length) return null
  if (triangle.length == 1) return Math.min([...triangle])

  function helper(level, c) {
    if (level == triangle.length) {
      return triangle[level - 1][c]
    }
    let left = helper(level + 1, c)
    let right = helper(level + 1, c + 1)
    return Math.min(left, right) + triangle[level - 1][c]
  }
  helper(1, 0)
};

var minimumTotal = function (triangle) {
  if (!triangle.length) return null
  if (triangle.length == 1) return Math.min([...triangle])
  let arr = []
  for (let i = 0; i < triangle.length; i++) {
    arr[i] = []
  }
  function helper(level, c) {
    if (arr[level][c]) {
      return arr[level][c]
    }
    if (level == triangle.length - 1) {
      return triangle[level][c]
    }
    let left = helper(level + 1, c)
    let right = helper(level + 1, c + 1)
    arr[level][c] = Math.min(left, right) + triangle[level][c]
    return arr[level][c]
  }
  return helper(0, 0)
};

var minimumTotal = function (triangle) {
  if (!triangle.length) return null
  if (triangle.length == 1) return Math.min(...triangle)
  let arr = []
  for (let i = 0; i < triangle.length; i++) {
    arr[i] = []
  }
  arr[0][0] = triangle[0][0]
  for (let i = 1; i < triangle.length; i++) {
    for (let j = 0; j < triangle[i].length; j++) {
      if (j == 0) {
        arr[i][j] = triangle[i][j] + arr[i - 1][j]
      } else if (j == triangle[i].length - 1) {
        arr[i][j] = triangle[i][j] + arr[i - 1][j - 1]
      } else {
        arr[i][j] = Math.min(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j]
      }
    }
  }
  return Math.min(...arr[arr.length - 1])
};
minimumTotal(
  [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
// @lc code=end

