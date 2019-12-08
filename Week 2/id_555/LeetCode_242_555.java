package lsn05.map;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/description/
 * https://leetcode.com/problems/valid-anagram/description/
 * 
 * 242. 有效的字母异位词
 *
 */
public class LeetCode_242_555 {

	public static void main(String[] args) {
		LeetCode_242_555 leetCode = new LeetCode_242_555();
		String s = "anagram";
		String t = "nagaram";
		boolean bol = leetCode.isAnagram(s, t);
		System.out.println(bol);
		boolean bol2 = leetCode.isAnagram2(s, t);
		System.out.println(bol2);
		boolean bol3 = leetCode.isAnagram3(s, t);
		System.out.println(bol3);
		boolean bol4 = leetCode.isAnagram3(s, t);
		System.out.println(bol4);
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
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

	public boolean isAnagram4(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

}
