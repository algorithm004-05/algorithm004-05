package leetcode.jacf.tech;

/**
 * @author YIN YIN
 * @time 2019-10-20 01:44:47
 * 26. 删除排序数组中的重复项
 * remove-duplicates-from-sorted-array
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int slowPointer = 0;
        for (int fastPointer = 1; fastPointer < nums.length; fastPointer++) {
            if (nums[slowPointer] != nums[fastPointer]) {
                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
        }
        return ++slowPointer;
    }
}
