package lsn18_sort;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 */
public class LeetCode_242_555 {
	public static void main(String[] args) {

		LeetCode_242_555 leetcode = new LeetCode_242_555();
		String s = "anagram";
		String t = "nagaram";
		boolean ans = leetcode.isAnagram(s, t);
		System.out.println(ans);
		boolean ans2 = leetcode.isAnagram2(s, t);
		System.out.println(ans2);
		boolean ans3 = leetcode.isAnagram3(s, t);
		System.out.println(ans3);
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}

}
