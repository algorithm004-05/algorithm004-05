/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    length = nums.length
    newNums= []
    newNums.length = length
    for(var i = 0; i< length;i++){
        newNums[(i+k)%length] = nums[i]
    }
    Object.assign(nums,newNums)
};