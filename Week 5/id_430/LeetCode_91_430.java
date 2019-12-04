/**
 * Created by panda on 2019/11/17.
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_91_430 {
    class Solution {
        /**
         * 求总数从后往前递推
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n];
            if (s.charAt(n - 1) != '0')
                dp[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') continue;
                if (i + 2 <= n && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] = dp[i + 1] + (i + 2 < n ? dp[i + 2] : 1);
                } else {
                    dp[i] = dp[i + 1];
                }
            }
            return dp[0];
        }

    }
}
