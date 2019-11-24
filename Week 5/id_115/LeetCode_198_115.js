/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  //1.子问题 当前房屋偷取的最大金额 = 前一个房屋不偷 + 当前房屋 || 前一个房屋偷
  //2.状态空间 nums[i][0] 当前房屋不偷  nums[i][1] 当前房屋偷
  //3.DP方程 nums[i][0] = nums[i-1][1] nums[i][1] = nums[i-1][0] + nums[i]
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  let sum = new Array(nums.length)
  for (let i = 0; i < sum.length; i++) {
    sum[i] = []
  }
  sum[0][0] = 0
  sum[0][1] = nums[0]
  for (let i = 1; i < nums.length; i++) {
    sum[i][0] = Math.max(sum[i - 1][1], sum[i - 1][0])
    sum[i][1] = sum[i - 1][0] + nums[i]
  }
  return Math.max(sum[nums.length - 1][0], sum[nums.length - 1][1])
};

var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  let arr = []
  arr[0] = nums[0]
  arr[1] = Math.max(nums[0], nums[1])
  let res = Math.max(arr[0], arr[1])
  for (let i = 2; i < nums.length; i++) {
    arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i])
    res = Math.max(arr[i], res)
  }
  return res
};

var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  let pre = nums[0]
  let cur = Math.max(nums[0], nums[1])
  for (let i = 2; i < nums.length; i++) {
    let temp = cur
    cur = Math.max(cur, pre + nums[i])
    pre = temp
  }
  return cur
};
// @lc code=end

