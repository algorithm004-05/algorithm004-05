package id_105;

public class LeetCode_231_105 {


    /**
     * 2的幂次方2进制只有一位为1。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count == 1;
    }



    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
