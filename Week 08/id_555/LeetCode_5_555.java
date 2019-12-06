package lsn20_string_palindrome;

/**
 * 5. 最长回文子串
 * 
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * https://www.cxyxiaowu.com/2869.html
 */
public class LeetCode_5_555 {

	public static void main(String[] args) {
		LeetCode_5_555 leetcode = new LeetCode_5_555();
		String s = "babad";
		leetcode.longestPalindrome(s);

	}

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		int maxLen = 1;
		String res = s.substring(0, 1);
		// 枚举所有长度大于等于 2 的子串
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i + 1 > maxLen && valid(s, i, j)) {
					maxLen = j - i + 1;
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

	private boolean valid(String s, int left, int right) {
		// 验证子串 s[left, right] 是否为回文串
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// ---------------------------------------------------------

	public String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		int maxLen = 1;
		String res = s.substring(0, 1);
		// 中心位置枚举到 len - 2 即可
		for (int i = 0; i < len - 1; i++) {
			String oddStr = centerSpread(s, i, i);
			String evenStr = centerSpread(s, i, i + 1);
			String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
			if (maxLenStr.length() > maxLen) {
				maxLen = maxLenStr.length();
				res = maxLenStr;
			}
		}
		return res;
	}

	private String centerSpread(String s, int left, int right) {
		// left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
		// right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
		int len = s.length();
		int i = left;
		int j = right;
		while (i >= 0 && j < len) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else {
				break;
			}
		}
		// 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
		return s.substring(i + 1, j);
	}

}
