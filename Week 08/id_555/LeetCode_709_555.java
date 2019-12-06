package lsn20_string;

/**
 * 709. 转换成小写字母
 * 
 * https://leetcode-cn.com/problems/to-lower-case/
 *
 */
public class LeetCode_709_555 {

	public static void main(String[] args) {
		LeetCode_709_555 leetcode = new LeetCode_709_555();
		String str = "Hello";
		String ans = leetcode.toLowerCase(str);
		System.out.println(ans);
	}

	public String toLowerCase(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 32);
			}
			ans += c;
		}
		return ans;
	}

	public String toLowerCase2(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++)
			if ('A' <= a[i] && a[i] <= 'Z')
				a[i] = (char) (a[i] - 'A' + 'a');
		return new String(a);
	}

	public String toLowerCase3(String str) {
		char[] st = new char[str.length()];
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= 65 && c <= 90) {
				c = (char) (c + 32);
			}
			st[i] = c;
		}
		return new String(st);
	}

	public String toLowerCase4(String str) {
		return str.toLowerCase();
	}

}
