package geektime.dp;

public class MaxSubArray {
// Kadane算法扫描一次整个数列的所有数值，
// 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
// 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
// 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
// 该算法可看成动态规划的一个例子。
// 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
// 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSumBefore = nums[0];
        int maxSumNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumBefore = Math.max(nums[i],nums[i] + maxSumBefore);
            maxSumNow = Math.max(maxSumBefore,maxSumNow);
        }
        return maxSumNow;
    }
}
