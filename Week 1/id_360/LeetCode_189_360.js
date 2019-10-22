/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// var rotate = function(nums, k) {
//     for (let i = 0; i < k; i ++) {
//         nums.unshift(nums.pop())
//     }
// };

var rotate = function(nums, k) {
    let len = nums.length
    if (len === 1) return
    k %= len
    var temp = 0
    nums.reverse()
    localReverse(nums, k, len - 1)
    localReverse(nums, 0, k - 1)
    function localReverse(nums, start, end) {
        while(start < end) {
            temp = nums[end]
            nums[end]  = nums[start]
            nums[start] = temp
            start++
            end--
        }
    }
};