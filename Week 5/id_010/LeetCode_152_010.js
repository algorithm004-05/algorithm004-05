/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    if(nums.length===1) return nums[0];
    
    let max = nums[0], min = nums[0], output = nums[0];
    
    for(let i = 1; i< nums.length; ++i){
        let prevMax = max;
        max = Math.max(nums[i],max*nums[i],min*nums[i]);
        min = Math.min(prevMax*nums[i],nums[i],min*nums[i]);
        
        output = Math.max(max,output)
    }
    
    return output;
};