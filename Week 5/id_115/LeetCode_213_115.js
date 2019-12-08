/*
 * @lc app=leetcode.cn id=213 lang=javascript
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  let sum = new Array(nums.length)
  for (let i = 0; i < sum.length; i++) {
    sum[i] = []
  }
  sum[0][0] = 0
  sum[0][1] = nums[0]

  for (let i = 1; i < nums.length - 1; i++) {
    sum[i][0] = sum[i - 1][0] + nums[i]
    sum[i][1] = Math.max(sum[i - 1][0], sum[i - 1][1])
  }
  let p1 = Math.max(sum[nums.length - 2][0], sum[nums.length - 2][1])

  sum[1][0] = 0
  sum[1][1] = nums[1]

  for (let i = 2; i < nums.length; i++) {
    sum[i][0] = sum[i - 1][0] + nums[i]
    sum[i][1] = Math.max(sum[i - 1][0], sum[i - 1][1])
  }
  let p2 = Math.max(sum[nums.length - 1][0], sum[nums.length - 1][1])

  return Math.max(p1, p2)
};

var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]

  function helper(nums) {
    let sum = new Array(nums.length)
    for (let i = 0; i < sum.length; i++) {
      sum[i] = []
    }
    sum[0][0] = 0
    sum[0][1] = nums[0]

    for (let i = 1; i < nums.length; i++) {
      sum[i][1] = sum[i - 1][0] + nums[i]
      sum[i][0] = Math.max(sum[i - 1][0], sum[i - 1][1])
    }
    return Math.max(sum[nums.length - 1][0], sum[nums.length - 1][1])
  }
  return Math.max(helper(nums.slice(1)), helper(nums.slice(0, nums.length - 1)))
};
var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  if (nums.length == 2) return Math.max(nums[0], nums[1])

  function helper(nums) {
    let sum = new Array(nums.length)
    sum[0] = nums[0]
    sum[1] = Math.max(nums[1], nums[0])
    let res = Math.max(sum[0], sum[1])

    for (let i = 2; i < nums.length; i++) {
      sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i])
      res = Math.max(sum[i], res)
    }
    return res
  }
  return Math.max(helper(nums.slice(1)), helper(nums.slice(0, nums.length - 1)))
};

var rob = function (nums) {
  if (!nums.length) return 0
  if (nums.length == 1) return nums[0]
  if (nums.length == 2) return Math.max(nums[0], nums[1])

  function helper(nums) {
    let pre = nums[0]
    let cur = Math.max(nums[1], nums[0])

    for (let i = 2; i < nums.length; i++) {
      let temp = cur
      cur = Math.max(cur, pre + nums[i])
      pre = cur
    }
    return cur
  }
  return Math.max(helper(nums.slice(1)), helper(nums.slice(0, nums.length - 1)))
};
// @lc code=end

