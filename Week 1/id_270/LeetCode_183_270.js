/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function (arr) {
  let nonZeroIndex = 0
  let len = arr.length  // 缓存一个len差这么多?
  for (let i = 0; i < len; i++) {
    if(arr[i] !== 0) {
      arr[nonZeroIndex++] = arr[i]
    }
  }
  for (let j = nonZeroIndex; j < len; j++) {
    arr[j] = 0
  }
};
let arr = [0, 1, 0, 3, 12]
moveZeroes(arr)
console.log(arr)
