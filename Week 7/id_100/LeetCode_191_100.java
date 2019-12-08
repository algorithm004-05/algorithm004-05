/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class LeetCode_191_100 {

    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

}