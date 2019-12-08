/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target,i=0,maps={}) {
    const map = maps;
        if(map[target-nums[i]] >=0){
            return [map[target-nums[i]],i];
        }else{
            map[nums[i]] = i;
            i++;
            if(i<nums.length){
                return twoSum(nums,target,i,map);
            }
        }
    
};