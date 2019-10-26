/*
 *
 * [84] 柱状图中最大的矩形
 */

/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function (heights) {
  let area = 0
  for (let i = 0; i < heights.length; i++) {
    for (let j = i; j < heights.length; j++) {
      let minHei = Number.MAX_SAFE_INTEGER;
      for (let k = i; k <= j; k++) {
        minHei = minHei > heights[k] ? heights[k] : minHei
      }
      let nowArea = minHei * (j - i + 1)
      area = area > nowArea ? area : nowArea
    }
  }
  return area
};
/**
 * 耗时：超出时间限制
 * 时间复杂度O(n^3)
 */
// ------------------------------------------
var largestRectangleArea = function (heights) {
  let area = 0
  for (let i = 0; i < heights.length; i++) {
    let minHei = Number.MAX_SAFE_INTEGER;
    for (let j = i; j < heights.length; j++) {
      minHei = minHei > heights[j] ? heights[j] : minHei
      let nowArea = minHei * (j - i + 1)
      area = area > nowArea ? area : nowArea
    }
  }
  return area
};
/**
 * 耗时：1732ms 击败13.22%
 * 内存：35.4
 * 时间复杂度O(n^2) 优化之后的暴力法
 */
// ------------------------------------------
var largestRectangleArea = function (heights) {
  let area = 0
  let arr = [-1]
  for (let i = 0; i < heights.length; i++) {
    while (arr[arr.length - 1] !== -1 && heights[arr[arr.length - 1]] >= heights[i]) {
      area = Math.max(area, heights[arr.pop()] * (i - arr[arr.length - 1] - 1))
    }
    arr.push(i)
  }
  while (arr[arr.length-1] !== -1) {
    area = Math.max(area, heights[arr.pop()] * (heights.length - arr[arr.length - 1] - 1))
  }
  return area
};
/**
 * 耗时：72ms 击败95.04%
 * 内存：36.5
 * 时间复杂度O(n)
 */
// ------------------------------------------