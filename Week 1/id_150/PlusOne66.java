package com.geek.lee.leetcode.easy;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组

/**
 * 66. 加一
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {

        /**
         * 分析题后第一想法:遍历数组, 在最后一个元素上+1
         * 考虑特殊情况,当末尾为9的时候需要进1.如 12 -> 13
         * 再有特殊场景需要扩充数组的 如 99 -> 100 999 -> 1000
         * 此时对数组扩种原长度+1.将数组第一个元素置为1即可
         * 这个arr[0] = 1 很有灵性.
         *
         */
        if (null == digits) {
            return digits;
        }

        for (int i = digits.length; i <= 0 ; i --) {
            digits[i] ++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] res = new PlusOne66().plusOne(new int[]{9,9,8});

        for (int i = 0; i < res.length; i ++) {
            System.out.println(res[i]);
        }
    }
}
