package lsn20_string_palindrome;

/**
 * 680. 验证回文字符串 Ⅱ
 * 
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class LeetCode_680_555 {
	public static void main(String[] args) {
		LeetCode_680_555 leetcode = new LeetCode_680_555();
		String s = "abcba";
		System.out.println(leetcode.validPalindrome(s));
	}

	public boolean validPalindrome(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = chars.length - 1;
		// 双指针循环找出不等于的字符索引
		while (i < j && chars[i] == chars[j]) {
			i++;
			j--;
		}
		// 删除左边循环判断
		if (isValid(chars, i + 1, j))
			return true;
		// 删除右边循环判断
		if (isValid(chars, i, j - 1))
			return true;
		// 如果上面都是false，那么结果肯定是false
		return false;
	}

	// 验证是否是回文
	private boolean isValid(char[] chars, int i, int j) {
		while (i < j) {
			if (chars[i++] != chars[j--]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * https://leetcode.com/problems/valid-palindrome-ii/discuss/209252/Java-Python-Two-Pointers-with-Thinking-Process
	 */
	public boolean validPalindrome2(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			}
			i++;
			j--;
		}
		return true;
	}

	/* Check is s[i...j] is palindrome. */
	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
