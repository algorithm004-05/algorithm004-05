/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    if(k === 0) return []
    let number = [], results = [] 
    for(let i = 0; i<k;++i){
        number.push(nums[i])
    }
    results.push(Math.max(...number))
    for(let i = k; i<nums.length; i++){
        number.shift()
        number.push(nums[i])
        results.push(Math.max(...number))
    }
    
    return results
};