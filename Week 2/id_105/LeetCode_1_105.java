package id_105;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_105 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ; i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{ map.get(num),i};
            }else{
                map.put(nums[i], i); //登记当前值和当前值对应的位置
            }
        }
        return new int[]{-1, -1};
    }
}
