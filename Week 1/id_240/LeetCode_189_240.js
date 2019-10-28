/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    //O(n)
    // let temp = k % nums.length;
    // for(let i = 0; i < temp; i++){
    //     nums.unshift(nums.pop())
    // }

    //O(1)
    let temp = k % nums.length;
    spliceArr = nums.splice(-temp,temp)
    nums.unshift(...spliceArr)
};