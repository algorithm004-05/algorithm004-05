/*
 *
 * [1] 两数之和
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  for (let i = 0; i < nums.length - 1; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        return [i, j]
      }
    }
  }
};

/**
 * 耗时：144ms 击败52.80%
 * 内存：34.6mb
 * 时间复杂度O（n^2）
 */
// ------------------------------------------
var twoSum = function (nums, target) {
  let obj = {}
  for (let i = 0; i < nums.length; i++) {
    if (obj[target - nums[i]] !== undefined) {
      return [obj[target - nums[i]], i]
    }
    obj[nums[i]] = i
  }
};
/**
 * 耗时：64ms 击败97.20%
 * 内存：34.5mb
 * 时间复杂度O（n）
 */
// ------------------------------------------
var twoSum = function (nums, target) {
  let map = new Map()
  for (let i = 0; i < nums.length; i++) {
    let index = map.get(target - nums[i])
    if (index !== undefined) return [index, i]
    map.set(nums[i], i)
  }
};
/**
 * 耗时：68ms 击败94.20%
 * 内存：34.8mb
 * 时间复杂度O（n）
 */
// ------------------------------------------