public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(numToIndex.containsKey(target - nums[i])) {
                return new int[]{numToIndex.get(target - nums[i]), i};
            }
            
            numToIndex.put(nums[i], i);
        }
        
        // This should not happen since one solution existed.
        return new int[]{-1, -1};
    }
}