package leetcode.jacf.tech;

/**
 * @author YIN YIN
 * @time 2019-10-20 01:44:47
 * [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
 * [remove-duplicates-from-sorted-array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 * 
 * 给定一个**排序数组**，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在**原地修改输入数组**并在使用 O(1) 额外空间的条件下完成。
 * 
 * 算法流程：
 * 1. 给定数组 [a_1,a_2,...,a_n]，已经过排序
 * 2. [a_1,a_2,...,a_n]，`i`为慢指针，最终输出`i+1`即为不重复部分；`j`为快指针，用于将不相等的两个数字交换
 *     ↑   ↑
 *     i   j
 * 3. [a_1,a_2,a_3,a_4,...,a_n]，移动`j`，如果`nums[i]`与`nums[j]`相等，继续移动`j`；否则`++i`，交换`nums[i]=nums[j]`
 *     ↑       ↑
 *     i       j
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
