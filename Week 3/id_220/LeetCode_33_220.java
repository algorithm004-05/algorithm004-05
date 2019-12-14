/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int midValue = nums[mid];
            if (midValue < nums[start]) {
                // 右侧有序, [6,7,0,1,2,4,5]
                if (midValue < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                // 左侧有序，[4,5,6,7,0,1,2]
                if (nums[start] <= target && target <= midValue) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start] == target ? start : -1;
    } 
}

