package week5;

/**
 * @author shizeying
 * @date 2019/11/16 15:09
 * @description
 */
public class leetcode_53 {
  public int maxSubArray1(int[] nums) {
    int ans = nums[0];
    int sum = 0;
    for (int num : nums) {
      // 如果sum>0表正在做的加法是一个增长的结果
      if (sum > 0) {
        sum += num;
      } else {
        // 如果sum变为负数了,则证明现在做得是一个减小的结果
        // 不是我们需要的,就将其舍去
        sum = num;
      }
      // 对比取出最大值
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int[] dp = new int[nums.length];
    dp[0] = max;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public int maxSubArray3(int[] nums) {
    int max = Integer.MIN_VALUE;
    int prev = 0;
    for (int i = 0; i < nums.length; i++) {
      prev = Math.max(prev + nums[i], nums[i]);
      max = Math.max(max, prev);
    }
    return max;
  }
}
