/*
 *
 * [88] 合并两个有序数组
 */

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
  let l1 = m - 1
  let l2 = n - 1
  let l = m + n - 1
  while (l1 >= 0 && l2 >= 0) {
    nums1[l--] = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--]
  }
  nums1.splice(0, l2 + 1, ...nums2.slice(0, l2 + 1))
};
/**
 * 耗时：60ms 击败98.2%
 * 内存：33.7mb
 * 时间复杂度O(m+n)
 */
// ------------------------------------------
var merge = function (nums1, m, nums2, n) {
  nums1.splice(m, nums1.length - m)
  Object.assign(nums1, [...nums1, ...nums2].sort((a, b) => a - b))
};
/**
 * 耗时：68ms 击败88.08%
 * 内存：35.1mb
 * 时间复杂度  不会算 抄过来的 有点狠 assign将数组元素制定给nums1
 */
// ------------------------------------------