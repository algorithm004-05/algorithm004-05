//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
// 2. 排序+二分查找 时间O(logn) 空间O(n)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int midIdx = 0;
        while (left < right) {
            midIdx = (left + right) / 2;
            // 注意这里的是小于等于
            if (nums[left] <= nums[midIdx] && nums[right] < nums[midIdx]) {
                left = midIdx + 1;
            } else if (nums[left] <= nums[midIdx] && nums[right] > nums[midIdx]) {
                midIdx = left;
                break;
            } else if (nums[left] > nums[midIdx] && nums[right] > nums[midIdx]) {
                right = midIdx;
            }
        }
        midIdx = left;
        int[] newnums = new int[nums.length];
        System.arraycopy(nums, midIdx, newnums, 0, nums.length - midIdx);
        System.arraycopy(nums, 0, newnums, nums.length - midIdx, midIdx);
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (newnums[mid] > target) {
                right = mid - 1;
            } else if (newnums[mid] < target) {
                left = mid + 1;
            } else {
                return (midIdx + mid) % nums.length;
            }
        }
        return newnums[left] == target ? (midIdx + left) % nums.length : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
