//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 归并排序
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }
    private int merge (int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int cnt = merge(nums, start, mid) + merge(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
