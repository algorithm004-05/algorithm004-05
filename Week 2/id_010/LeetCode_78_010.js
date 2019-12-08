/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let results = []
    results.push([])
    let len = nums.length
    if(len === 0) return results
    
    for(let i=0;i<len;++i){
        let subLen = results.length
        for(let j = 0; j<subLen; ++j){
            let arr = [].concat(results[j])
            arr.push(nums[i])
            results.push(arr)
        }
    }
    
    return results
};