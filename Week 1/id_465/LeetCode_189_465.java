package leetcode.jacf.tech;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author jacf
 * @time 2019-10-20 15:29:35
 * 189. 旋转数组
 * rotate-array
 * https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 算法流程：
 * 1. 生成一个临时数组`tmpArray=[nums,nums]`，
 *    `firstIndex=nums.leng-k%nums.length`，
 *    `tmpArray[firstIndex,firstIndex+nums.length-1]`（包括首个和最终元素）即为`nums`最终结果
 * 2. 遍历数组`nums`，修改数组元素
 */
public class RotateAarray {
    public static void rotate(int[] nums, int k) {
        int[] tmpArray = new int[nums.length * 2];
        System.arraycopy(nums, 0, tmpArray, 0, nums.length);
        System.arraycopy(nums, 0, tmpArray, nums.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArray[nums.length - k % nums.length + i];
        }
    }
}
