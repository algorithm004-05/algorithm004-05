package lesson.week.one;

import java.util.Arrays;

/**
 * Created by liangwj20 on 2019/10/20 20:05
 * Description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 */
public class LeetCode_66_320 {

    public static void main(String[] args) {
//        int[] digits = new int[]{4,3,2,1};
        int[] digits = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * 加1
     * 时间复杂度O(n)
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] % 10 != 0) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        System.arraycopy(digits,0, nums, 1, digits.length);
        return nums;
    }
}
