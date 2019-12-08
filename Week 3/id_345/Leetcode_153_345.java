package xyz.isok.algorithm.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
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
public class No153FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] src1 = {3,4,5,1,2};
        int[] src2 = {4,5,6,7,0,1,2};
        int[] src3 = {1,2,3};
        int[] src4 = {2,3,4,5,1};
        No153FindMinimumInRotatedSortedArray search = new No153FindMinimumInRotatedSortedArray();
        System.out.println(search.findMin(src1));
        System.out.println(search.findMin(src2));
        System.out.println(search.findMin(src3));
        System.out.println(search.findMin(src4));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];
        int first = nums[0];
        while (left <= right){
            int mid = left + (right - left)/2;

            if (mid + 1 <= right && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }

            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] >= first){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
}
