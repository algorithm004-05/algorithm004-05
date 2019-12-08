/*
 * @lc app=leetcode.cn id=74 lang=javascript
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  let first = 0, last = matrix.length - 1
  if (!matrix.length) return false
  if (!matrix[0].length) return false
  while (first <= last) {
    let mid = Math.floor((first + last) / 2)
    let midArr = matrix[mid]

    if (midArr[0] <= target && midArr[midArr.length - 1] >= target) {

      return helper(midArr)
    } else if (midArr[0] > target) {
      last = mid - 1
    } else if (midArr[midArr.length - 1] < target) {
      first = mid + 1
    }
  }
  return false
  function helper(arr) {
    let left = 0, right = arr.length - 1
    if (!arr.length) return false
    while (left <= right) {
      let mid = Math.floor((left + right) / 2)
      if (arr[mid] === target) return true
      if (arr[mid] > target) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }
    return false
  }
};
// @lc code=end

