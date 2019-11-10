/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class LeetCode_153_100 {
    /**
     * 利用二分法实现
     * 每次轮询与nums[0]进行比较，如果mid值大于nums[0],则最小值一定在mid右侧
     * 否则在左侧
     * 时间复杂度：O(logN)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}