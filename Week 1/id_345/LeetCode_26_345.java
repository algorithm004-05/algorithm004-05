package xyz.isok.algorithm.leetcode.easy;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class No26RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Solution.removeDuplicates(nums));
    }

    static class Solution {
        public static int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }

            int pre = nums[0];
            int cursor = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != pre){
                    pre = nums[i];
                    nums[cursor] = pre;
                    cursor++;
                }
            }
            for (int i = cursor; i < nums.length; i++) {
                nums[i] = 0;
            }

            return cursor;
        }
    }

}
