/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */

public class Leetcode_91_450 {
	public int numDecodings(String s) {
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = 1;
		if (s.charAt(len - 1) != '0') {
			dp[len - 1] = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			int ans1 = dp[i + 1];
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = dp[i + 2];
			}
			dp[i] = ans1 + ans2;

		}
		return dp[0];
	}
}
