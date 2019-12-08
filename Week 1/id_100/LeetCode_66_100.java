/**
 * 
 */
public class LeetCode_66_100 {
    /**
     * 进位操作，要么进位，要么不进，
     * 不进位的时候停止操作，直接返回
     * 若遍历完整个数组还是一直进位，那么它一定是[9,9]类似这种形式，
     * 并且在此时需要开辟n+1个空间
     * ------
     * 时间复杂度O(n),最坏的空间复杂度O(n)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if((digits[i]+1)%10 != 0) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}