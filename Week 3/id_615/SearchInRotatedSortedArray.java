package com.chenlei.geektime.leetcode.lesson11;

/**
 * 搜索旋转排序数组
 * <pre>
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
 *
 * </pre>
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {

       //左右边界
       int left = 0;
       int right = nums.length - 1;

       while (left < right){
           //取中位数,左边界收缩，取右中位
           int mid  = (left + right ) >>> 1;

           // 当[0,mid]有序时,向右规约条件
           if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
               left = mid + 1;  //左边界收缩

           // 当[0,mid]发生旋转时，向右规约条件
           }else if(nums[mid] < target && target < nums[0]){
               left = mid + 1;  //左边界收缩
           }else{
               right = mid;
           }

       }

       //检查最后值
       if(nums[left] == target){
            return left;
       }

       return -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int index = searchInRotatedSortedArray.search(nums,target);
        System.out.println(index);

        int[] nums2 = new int[]{4,5,6,7,0,1,2};
        int target2 = 3;
        int index2 = searchInRotatedSortedArray.search(nums2,target2);
        System.out.println(index2);

    }
}
