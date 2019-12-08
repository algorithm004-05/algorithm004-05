/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let hash = {}
    for(let i = 0; i < nums.length; i++){
        if(hash[nums[i]] !== undefined){    //不能直接使用hash[nums[i]]，会出现hash[nums[i]] === 0的情况
            return [hash[nums[i]],i]
        }else{
            hash[target - nums[i]] = i
        }
    }
};