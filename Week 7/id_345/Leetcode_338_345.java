package xyz.isok.algorithm.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class No338CountingBits {

    public static void main(String[] args) {
        No338CountingBits countingBits = new No338CountingBits();
        int[] result = countingBits.countBits1(2);
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();

        result = countingBits.countBits1(5);
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int j = i;
            while (j != 0){
                j &= (j - 1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    /**
     * 摘自他人 DP解法
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }



}
