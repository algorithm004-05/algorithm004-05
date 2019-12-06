package lsn20_string;

import java.util.Arrays;

/**
 * 344. 反转字符串
 * 
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class LeetCode_344_555 {
	public static void main(String[] args) {
		LeetCode_344_555 leetcode = new LeetCode_344_555();
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
//		leetcode.reverseString(s);
		leetcode.reverseString2(s);
		System.out.println(Arrays.toString(s));
	}

	public void reverseString(char[] s) {
		if (s == null) {
			return;
		}
		int n = s.length;
		for (int i = 0; i < n >> 1; i++) {
			int j = n - i - 1;
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}

	/**
	 * 双指针
	 */
	public void reverseString2(char[] s) {
		if (s == null) {
			return;
		}
		for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}

	public void reverseString3(char[] s) {
		if (s == null || s.length < 2) {
			return;
		}
		int left = -1;
		int right = s.length;
		while (++left < --right) {
			char c = s[left];
			s[left] = s[right];
			s[right] = c;
		}
		return;
	}

}
