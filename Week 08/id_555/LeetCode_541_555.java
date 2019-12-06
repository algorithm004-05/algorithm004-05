package lsn20_string;

/**
 * 541. 反转字符串 II
 * 
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 */
public class LeetCode_541_555 {

	public static void main(String[] args) {
		LeetCode_541_555 leetcode = new LeetCode_541_555();
		String s = "abcdefg";
		int k = 2;
		System.out.println(leetcode.reverseStr(s, k));
	}

	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}

}
