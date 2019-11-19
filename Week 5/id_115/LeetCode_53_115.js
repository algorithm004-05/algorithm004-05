/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子序和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
  let total = nums[0]
  let ans = 0
  for (let i = 1; i < nums.length; i++) {
    if (total < 0) {
      total = nums[i]
    } else {
      total += nums[i]
    }
    ans = Math.max(total, ans)
  }
  return ans
};
var maxSubArray = function (nums) {
  let max = Number.MAX_SAFE_INTEGER
  for (var i = 0; i < nums.length; i++) {
    let sum = 0
    for (var j = i; j < nums.length; j++) {
      sum += nums[j]
      max = Math.max(sum, max)
    }
  }
  return max
};

// @lc code=end

