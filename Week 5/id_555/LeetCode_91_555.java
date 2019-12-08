package lsn12_dynamic_programming;

/**
 * 91. 解码方法
 * 
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class LeetCode_91_555 {

	public static void main(String[] args) {
		LeetCode_91_555 leetcode = new LeetCode_91_555();
		String s = "226";
		System.out.println(leetcode.numDecodings(s));
	}

	public int numDecodings(String s) {
		int len = s.length();
		int end = 1;
		int cur = 0;
		if (s.charAt(len - 1) != '0') {
			cur = 1;
		}
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				end = cur;
				cur = 0;
				continue;
			}
			int ans1 = cur;
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i + 1) - '0';
			if (ten + one <= 26) {
				ans2 = end;
			}
			end = cur;
			cur = ans1 + ans2;
		}
		return cur;
	}

}
