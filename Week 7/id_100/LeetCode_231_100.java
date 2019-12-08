/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class LeetCode_231_100 {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

}