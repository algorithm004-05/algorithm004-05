/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // 长度为 1 的输入不修改，直接返回
        if (nums.length == 1) {
            return 1;
        }
        int len = 1;
        int index = 0, p = 1;
        // 有序数组相同元素相邻，遍历数组与查找元素是否相同即可
        for ( ; p < nums.length; p++) {
            if (nums[p] == nums[index]) {
                continue;
            }
            if (nums[p] != nums[index]) {
                nums[index + 1] = nums[p];                
                index = index + 1;
                len++;
            }
        }
        return len;
    }
}