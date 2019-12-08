/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_231_430 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
