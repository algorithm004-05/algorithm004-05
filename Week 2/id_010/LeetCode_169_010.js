/**
 * @param {number[]} nums
 * @return {number}
 */
// function findResult(value,key,map){
    
// }

var majorityElement = function(nums) {
    let myMap = new Map()
    for(let i =0;i<nums.length;++i){
        if(myMap[nums[i]]>=1){
            myMap[nums[i]]++
        }
        else myMap[nums[i]] = 1
    }
    
    let half = nums.length/2
    let result 
    for(let i =0;i<nums.length;++i){
        if(myMap[nums[i]]>=half){
            result = nums[i]
            break
        }
    }
    
    // console.log(result)
    return result
};