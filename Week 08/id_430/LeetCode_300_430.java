import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by panda on 2019/12/8.
 */

public class LeetCode_300_430 {
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int n = nums.length;
            if (n == 0 || n == 1) {
                return n;
            }
            Arrays.fill(dp, 1);
            int max = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if (n == 0 || n == 1) {
                return n;
            }
            int[] tails = new int[n];
            int res = 0;
            for (int k = 0; k < n; k++) {
                int i = 0, j = res;
                // 二分找到修改或插入位置
                while (i < j) {
                    int mid = (i + j) / 2;
                    // mid可能为指定位置
                    if (tails[mid] < nums[k]) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                // i=j
                tails[i] = nums[k];
                // 当前位置插入元素
                if (j == res) {
                    res++;
                }
            }
            return res;
        }
    }
}
