/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_191_430 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
