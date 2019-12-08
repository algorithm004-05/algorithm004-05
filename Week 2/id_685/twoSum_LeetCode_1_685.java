import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
            
        for(int i = 0 ; i < nums.length ; i++ ) {
            int y = target-nums[i];
                if(map.containsKey(y)){

                    // return new ArrayList<Integer,Integer>() {i map.getValue(y)};
                    // new ArrayList() {"1",2,3,"4" };
                    int [] array = new int[2];
                    array[1] = i;
                    array[0] = map.get(y);
                    return array ;
                }
                map.put(nums[i],i);

        }
        throw new IllegalArgumentException("no solution!");

    }
}
// @lc code=end

