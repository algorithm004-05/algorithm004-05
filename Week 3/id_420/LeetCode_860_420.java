package geekbang.myleetcode.week03;

/**
 * lesson03
 */
public class LeetCode_860_420 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,5,5,10,20};
        Solution solution = new LeetCode_860_420().new Solution();
        boolean result = solution.lemonadeChange(nums);
        System.out.println("main:" + result);

    }

    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int bill : bills) {
                if (5 == bill) {
                    five ++;
                } else if (10 == bill) {
                    five --;
                    ten ++;
                } else if (0 < ten) {
                    five --;
                    ten --;
                } else {
                    five -= 3;
                }

                if (0 > five) {
                    return false;
                }
            }

            return true;
        }
    }
}
