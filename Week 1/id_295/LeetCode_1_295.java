import java.util.HashMap;

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int index = 0; index < nums.length; index++) {
                int complement = target - nums[index];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), index};
                }
                map.put(nums[index], index);
            }
            throw new IllegalArgumentException("No answer");
        }
    }
}

