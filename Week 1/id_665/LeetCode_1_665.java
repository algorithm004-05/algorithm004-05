//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //1. 建立hashmap，以值为key，下标为value。
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        //2. 判断差值元素是否在原来的Map中存在，且不等于自身下标，则返回结果。
        for (int key = 0; key < nums.length; key++) {
            int sub = (numsMap.get(target - nums[key]) == null) ? 0 : numsMap.get(target - nums[key]);
            if (sub != 0 && key != sub) {
                return new int[]{key, sub};
            }
        }
        throw new IllegalArgumentException("Not Found!");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
