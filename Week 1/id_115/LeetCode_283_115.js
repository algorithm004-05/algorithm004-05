/*
 *
 * [283] 移动零
 */

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i]) {
      nums[j] = nums[i]
      if (j !== i) {
        nums[i] = 0
      }
      j++
    }
  }
};
/**
 * 耗时：54ms 击败98.68%
 * 内存：35.8mb
 * 时间复杂度O（n）
 */
// ------------------------------------------
var moveZeroes = function (nums) {
  let n = nums.length
  let j = 0
  for (let i = 0; i < n; i++) {
    if (nums[i]) {
      nums[j++] = nums[i]
    }
  }
  while (j < n) {
    nums[j++] = 0
  }
};
/**
 * 耗时：112ms 击败13.64%
 * 内存：35.8mb
 * 时间复杂度O（n） 为啥这么慢？
 */
// ------------------------------------------