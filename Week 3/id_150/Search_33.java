package com.geek.lee.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 33. 搜索旋转排序数组
 */
public class Search_33 {

    /**
     * 因为数组元素是有规律的.
     * 这个问题即可划分为查找数组中最小元素的问题. 只不过这次我们要元素的下标.
     * 基于解决这个问题 + 二分查找 即可定位到要搜索的内容
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int minIndex = findMinIndex(nums);
        if (target == nums[minIndex]) {
            return minIndex;
        }
        if (minIndex == 0) {
            return searchIndex(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[0]) {
            return searchIndex(nums, target,0, minIndex);
        }
        return searchIndex(nums, target, minIndex, nums.length - 1);
    }

    private int searchIndex(int[] nums,int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int findMinIndex(int[] nums) {
        // 如果数组最后一个元素比第一个元素大,说明就是有序的,返回第一个元素即可
        if (nums[nums.length - 1] >= nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid -1] > nums[mid]) {
                return mid;
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Search_33().search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }
}
