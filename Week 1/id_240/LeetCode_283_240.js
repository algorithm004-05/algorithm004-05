/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    // let j = 0
    // for(let i = 0 ;i<nums.length;i++){
    //     if(nums[i] !== 0){
    //         nums[j] = nums[i]
    //         if(i !== j){
    //             nums[i] = 0
    //         }
    //         j++
    //     }
    // }
    // [ 0, 1, 0, 3, 12 ]
    // [ 1, 0, 0, 3, 12 ]
    // [ 1, 0, 0, 3, 12 ]
    // [ 1, 3, 0, 0, 12 ]
    // [ 1, 3, 12, 0, 0 ]

    let temp = 0
    for(let i = 0;i<nums.length;i++){
        if(nums[temp] === 0){
            nums.splice(temp,1)
            nums[nums.length] = 0
        }else{
            temp++
        }
    }
};