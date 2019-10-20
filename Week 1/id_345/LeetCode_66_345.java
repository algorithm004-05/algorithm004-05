package xyz.isok.algorithm.leetcode.easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class No66PlusOne {

    public static void main(String[] args) {
        int[] num = {4,5,6};
        Solution.plusOne(num);
        for (int i : num) {
            System.out.print(i +" " );
        }
    }

    static class Solution {
        public static int[] plusOne(int[] digits) {
            int length = digits.length;
            boolean great = true;
            for (int i = 0; i < length; i++) {
                great = great && digits[i] == 9;
            }
            if (great){
                int[] result = new int[length + 1];
                result[0] = 1;
                return result;
            }else {
                for (int i = length - 1; i >= 0; i--) {
                    digits[i] += 1;
                    if (digits[i] <= 9){
                        break;
                    }else {
                        digits[i] = 0;
                    }
                }
            }
            return digits;
        }
    }

}
