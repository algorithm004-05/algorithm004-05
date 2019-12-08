class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int extra = target - nums[i];
            if (map.get(extra) != null) {
                result[0] = map.get(extra);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}