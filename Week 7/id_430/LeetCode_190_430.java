/**
 * Created by panda on 2019/12/1.
 */
public class LeetCode_190_430 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            // 最低位
            for (int i = 0; i < 32; i++) {
                // 靠后的位先拼接
                // 括号一定不能省
                result = (result << 1) + (n & 1);
                n >>= 1;
            }
            return result;
        }
    }
}
