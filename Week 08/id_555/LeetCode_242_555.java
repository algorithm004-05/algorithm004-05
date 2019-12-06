package lsn20_string;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 */
public class LeetCode_242_555 {
	public static void main(String[] args) {
		LeetCode_242_555 leetcode = new LeetCode_242_555();
//		String s = "BB11anagram";
//		String t = "nagaram11BB";
		String s = "anagram";
		String t = "nagaram";
		System.out.println(leetcode.isAnagram(s, t));
//		System.out.println(leetcode.isAnagram2(s, t));
	}

	/**
	 * 针对小写字母
	 */
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

	/**
	 * 针对任意字符
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
			char c2 = t.charAt(i);
			hashMap.put(c2, hashMap.getOrDefault(c2, 0) - 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hashMap.get(c) != 0) {
				return false;
			}
		}
		return true;
	}

}
