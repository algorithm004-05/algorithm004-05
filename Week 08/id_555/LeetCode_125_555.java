package lsn20_string_palindrome;

/**
 * 125. 验证回文串
 * 
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 
 */
public class LeetCode_125_555 {

	public static void main(String[] args) {
		LeetCode_125_555 leetcode = new LeetCode_125_555();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(leetcode.isPalindrome(s));
		System.out.println(leetcode.isPalindrome2(s));
	}

	public boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		for (int i = 0, j = c.length - 1; i < j;) {
			if (!Character.isLetterOrDigit(c[i]))
				i++;
			else if (!Character.isLetterOrDigit(c[j]))
				j--;
			else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
				return false;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		char[] c = s.toCharArray();
		int i = 0, j = c.length - 1;
		while (i < j) {
			if (!isLetterOrDigit(c[i]))
				i++;
			else if (!isLetterOrDigit(c[j]))
				j--;
			else if (toLowerCase(c[i++]) != toLowerCase(c[j--]))
				return false;
		}
		return true;
	}

	boolean isLetterOrDigit(char c) {
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	char toLowerCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (char) (c + 32);
		}
		return c;
	}

	public boolean isPalindrome3(String s) {
		// 先转化字符串
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		char[] c = actual.toCharArray();
		int i = 0, j = c.length - 1;
		while (i < j) {
			if (c[i++] != c[j--])
				return false;
		}
		return true;
	}

}
