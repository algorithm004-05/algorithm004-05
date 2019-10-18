import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length < 2){
            return new int[0];
        }

        Map<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(cache.containsKey(key)){
                return new int[]{cache.get(key), i};
            }
            cache.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

