/*
 *
 * [189] 旋转数组
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  for (let i = 0; i < k; i++) {
    nums.unshift(nums.pop(nums.length - 1))
  }
};
/**
 * 耗时：112ms 击败52.2%
 * 内存：35.5mb
 * 时间复杂度O（n*k） 请大佬评论一下时间复杂度分析对不对
 */
// ------------------------------------------
var rotate = function (nums, k) {
  nums.splice(0, 0, ...nums.splice(nums.length - k, k))
};
/**
 * 耗时：80ms 击败90.2%
 * 内存：35.2mb
 * 时间复杂度 不会算 请大佬指教
 */
// ------------------------------------------
var rotate = function (nums, k) {
  let pre = null, temp = null;
  for (let i = 0; i < k; i++) {
    pre = nums[nums.length - 1]
    for (let i = 0; i < nums.length; i++) {
      temp = nums[i]
      nums[i] = pre
      pre = temp
    }
  }
};
/**
 * 耗时：268ms 击败11.3%
 * 内存：34.9mb
 * 时间复杂度O（n*k）
 */
// ------------------------------------------
var rotate = function (nums, k) {
  let n = nums.length
  k = k % nums.length
  reverse(0, n - 1)
  reverse(0, k - 1)
  reverse(k, n - 1)
  function reverse(start, end) {
    while (start < end) {
      [nums[start], nums[end]] = [nums[end], nums[start]]
      start++
      end--
    }
  }
};
/**
 * 耗时：92ms 击败77.46%
 * 内存：36.2mb
 * 时间复杂度O（n） 
 */
// ------------------------------------------