/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26_100 {
    /**
     * 遍历整个数组，遇见与基元素不一致的，
     * 将其赋值至基元素的下一个索引位置，且基元素下标进行移动
     * 时间复杂度O(n)
     * */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int base = 0;//基元素下标
        for (int i = 1; i < nums.length; i++) {
            if(nums[base] != nums[i]) {
                nums[++base] = nums[i];
            }
        }
        return base+1;
    }
}