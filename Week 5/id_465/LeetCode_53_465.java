package leetcode.jacf.tech;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author jacf
 * <p>
 * get maximum subarray using dynamic programe
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
