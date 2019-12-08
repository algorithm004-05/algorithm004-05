package xyz.isok.algorithm.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class No190ReverseBits {

    /**
     * 双指针法
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int i = 0, j = 31, result = 0, temp;
        while (i < j) {
            result |= ((n >> i) & 1) << j;
            result |= ((n >> j) & 1) << i;
            i++;
            j--;
        }
        return result;
    }

    /**
     * 循环校验，0的位不需要交换
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        int result = 0, x;
        for (int i = 0; i < 32; i++) {
            x = (n >> i) & 1;
            if (x == 1){
                result |= (1 << (31 - i));
            }
        }
        return result;
    }



}

