/*
 * @lc app=leetcode.cn id=33 lang=javascript
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  if (!nums.length) return -1
  function helper(l, r) {
    if (l > r) return -1
    let mid = Math.floor((l + r) / 2)
    if (nums[mid] === target) return mid
    if (nums[mid] < nums[r]) {
      if (nums[mid] < target && nums[r] >= target) return helper(mid + 1, r)
      return helper(l, mid - 1)
    } else {
      if (nums[mid] > target && nums[l] <= target) return helper(l, mid - 1)
      return helper(mid + 1, r)
    }
  }
  return helper(0, nums.length - 1)
};
// @lc code=end

