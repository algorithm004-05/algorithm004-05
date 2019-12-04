/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {    
    let n = nums.length,
        a = []
    
    if(nums === null || n ===0) return 0;
    if(n === 1) return nums[0];

    a[0] = nums[0];
    a[1] = Math.max(nums[0],nums[1]);
    let res = Math.max(a[0],a[1]);
    
    for(let i = 2;i<n;++i){
        a[i] = Math.max(a[i-1],a[i-2]+nums[i]);
        res = Math.max(res,a[i]);
    }
    
    return res
};