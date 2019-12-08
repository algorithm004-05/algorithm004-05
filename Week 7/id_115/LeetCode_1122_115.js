/*
 * @lc app=leetcode.cn id=1122 lang=javascript
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function (arr1, arr2) {
  let max = Math.max(...arr1)
  let arr = new Array(max + 1).fill(0)
  for (let i = 0; i < arr1.length; i++) {
    arr[arr1[i]]++
  }
  arr1 = []
  for (let i = 0; i < arr2.length; i++) {
    while (arr[arr2[i]]) {
      arr1.push(arr2[i])
      arr[arr2[i]]--
    }
  }
  for (let i = 0; i <= max; i++) {
    while (arr[i]) {
      arr1.push(i)
      arr[i]--
    }
  }
  return arr1
};
let len = null
function setMaxHeap(arr) {
  len = arr.length - 1
  for (let i = len >> 1; i >= 0; i--) {
    heapify(arr, i)
  }
}
function heapify(arr, i) {
  let left = 2 * i + 1
  let right = 2 * i + 2
  let large = i
  if (left <= len && arr[left] > arr[large]) {
    large = left
  }
  if (right <= len && arr[right] > arr[large]) {
    large = right
  }
  if (large != i) {
    [arr[large], arr[i]] = [arr[i], arr[large]]
    heapify(arr, large)
  }
}
function heapSort(arr) {
  setMaxHeap(arr)
  for (let i = arr.length - 1; i >= 0; i--) {
    [arr[i], arr[0]] = [arr[0], arr[i]]
    len--
    heapify(arr, 0)
  }
  return arr
}
let arr = [2,4,6,8,9,1,24,7,3,4,7,5,6,01,2,3,5]
// @lc code=end

