import java.util.*;
/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class LeetCode_1_100 {

     /**
     * 暴力法
     * 时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 使用hash表,将其放置在hash表中，只需要遍历一次数组
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("error");
    }

}