package com.geek.lee.leetcode.medium;
/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */

/**
 * 153. 寻找旋转排序的数组中的最小值.
 */
public class FindMin_153 {

    /**
     * 二分查找法.
     * 可以通过从中间点定位旋转点
     * 找到旋转的点即最小点
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if (null == nums || nums.length == 0) {
            return -1;
        }
        // 如果数组最后一个元素比第一个元素大,说明就是有序的,返回第一个元素即可
        if (nums[nums.length - 1] >= nums[0]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid -1] > nums[mid]) {
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

    public static void main(String[] args) {
        System.out.println(new FindMin_153().findMin(new int[] {3,4,5,1,2}));
    }
}
