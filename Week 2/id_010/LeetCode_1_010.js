/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let myMap = new Map()
    for(let i = 0; i<nums.length;++i){
        if(myMap.has(target - nums[i])){
            return [myMap.get(target-nums[i]),i]
        }else{
            myMap.set(nums[i],i)
        }
    }
};