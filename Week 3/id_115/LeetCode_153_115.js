/*
 * @lc app=leetcode.cn id=153 lang=javascript
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  return nums.sort((a, b) => a - b)[0]
};
var findMin = function (nums) {
  if (nums.length === 1) return nums[0]
  if (nums[0] < nums[nums.length - 1]) return nums[0]
  let l = 0, r = nums.length - 1
  while (l <= r) {
    let mid = Math.floor((l + r) / 2)
    if (nums[mid] > nums[mid + 1]) return nums[mid + 1]
    if (nums[mid] < nums[mid - 1]) return nums[mid]
    if (nums[mid] < nums[r]) {
      r = mid - 1
    } else {
      l = mid + 1
    }
  }
};
// @lc code=end

