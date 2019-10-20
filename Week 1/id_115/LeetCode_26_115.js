/*
 * [26] 删除排序数组中的重复项
 */
// ---------------------------------------
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  let i = nums.length - 1
  let num = null;
  while (i >= 0) {
    if (nums[i] === num) {
      nums.splice(i, 1)
    } else {
      num = nums[i]
    }
    i--
  }
  return nums.length
};
/**
 * 耗时：104ms 击败68.2%
 * 内存：36.5mb
 * 时间复杂度O（n^2） 请大佬评论一下时间复杂度分析对不对
 */
// ------------------------------------------
var removeDuplicates = function (nums) {
  let i = 1
  let j = 0
  while (i < nums.length) {
    if (nums[i] !== nums[i - 1]) {
      j++
      nums[j] = nums[i]
    }
    i++
  }
  return j + 1
};
/**
 * 耗时：84ms 击败93.22%
 * 内存：36.5mb
 * 时间复杂度O（n）
 */