package id_535;

/**
 * created by lchen on 2019/10/20
 */
public class LeetCode_66_535 {

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        Solution4 solution4 = new Solution4();
        int[] targets = solution4.plusOne(nums);
        for (int num : targets) {
            System.out.print(num + " ");
        }
    }
}

class Solution4 {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        //判断数组中数字是否都为9
        for (int digit : digits) {
            if (digit != 9) {
                allNine = false;
            }
        }
        if (allNine) {
            int[] targets = new int[digits.length + 1];
            targets[0] = 1;
            return targets;
        }else  {
            int p1 = digits.length - 1;
            int result = digits[p1] + 1;
            while (result == 10) {
                digits[p1--] = 0;
                result = digits[p1] + 1;
            }
            digits[p1] = result;
            return digits;
        }

    }
}