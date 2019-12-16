package lsn20_string;

/**
 * 58. 最后一个单词的长度
 * 
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LeetCode_58_555 {

	public static void main(String[] args) {
		LeetCode_58_555 leetcode = new LeetCode_58_555();
//		String s = "Hello World";
//		String s = "HelloWorld";
		String s = "a";
		System.out.println(leetcode.lengthOfLastWord(s));
	}

	public int lengthOfLastWord(String s) {
		int end = s.length() - 1;
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		return end - start;
	}

	public int lengthOfLastWord3(String s) {
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ')
			end--;
		if (end < 0)
			return 0;
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ')
			start--;
		return end - start;
	}

	public int lengthOfLastWord2(String s) {
		s = s.trim();
		int start = s.lastIndexOf(" ") + 1;
		return s.substring(start).length();
	}

}
