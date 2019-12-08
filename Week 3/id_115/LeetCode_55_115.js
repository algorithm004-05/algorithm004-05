/*
 * @lc app=leetcode.cn id=55 lang=javascript
 *
 * [55] 跳跃游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  let k = 0
  for (let i = 0; i < nums.length; i++) {
    if (i > k) return false
    k = Math.max(k, i + nums[i])
  }
  return true
};
var canJump = function (nums) {
  let cur = nums.length - 1
  for (let i = nums.length - 1; i >= 0; i--) {
    if (i + nums[i] >= cur) {
      cur = i
    }
  }
  return cur === 0
};
// @lc code=end

