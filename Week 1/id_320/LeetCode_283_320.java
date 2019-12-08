package lesson.week.one;

import java.util.Arrays;

/**
 * Created by liangwj20 on 2019/10/20 19:11
 * Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 要求：1、必须在原数组上操作，不能拷贝额外的数组。2、尽量减少操作次数。
 */
public class LeetCode_283_320 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
//        moveZeroes_1(nums);
        moveZeroes_2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动零
     * 时间复杂度O(n), 空间复杂度O(1)
     * @param nums
     */
    private static void moveZeroes_1(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex++] = nums[i];
            }
        }
        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 移动零
     * 时间复杂度O(n), 空间复杂度O(1)
     * @param nums
     */
    private static void moveZeroes_2(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, notZeroIndex++, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
