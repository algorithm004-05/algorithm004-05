/*
 * @lc app=leetcode.cn id=493 lang=javascript
 *
 * [493] 翻转对
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function (nums) {
  let res = 0
  mergeSort(0, nums.length - 1)
  function mergeSort(left, right) {
    if (left >= right) return
    let mid = left + right >> 1
    mergeSort(left, mid)
    mergeSort(mid + 1, right)
    merge(left, mid, right)
  }
  function merge(left, mid, right) {
    let i = left
    let j = mid + 1
    let k = 0
    let arr = []
    console.log(nums, left, mid, right)
    while (j <= right) {
      let l = mid
      while (l >= left && nums[l] > 2 * nums[j]) {
        console.log(nums[l], nums[j], nums[l] >= 2 * nums[j])
        l--
        res++
      }
      while (i <= mid && nums[i] < nums[j]) {
        arr[k++] = nums[i++]
      }
      arr[k++] = nums[j++]
    }
    while (i <= mid) {
      arr[k++] = nums[i++]
    }
    for (let i = 0; i < arr.length; i++) {
      nums[left + i] = arr[i]
    }
  }
  return res
};
console.log(reversePairs([2,4,3,5,1]))
// @lc code=end

