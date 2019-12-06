package lsn20_string;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387_555 {

	public static void main(String[] args) {
		LeetCode_387_555 leetcode = new LeetCode_387_555();
//		String s = "loveleetcode";
//		String s = "leetcode";
		String s = "lEel";
//		System.out.println(leetcode.firstUniqChar(s));
//		System.out.println(leetcode.firstUniqChar2(s));
//		System.out.println(leetcode.firstUniqChar3(s));
		System.out.println(leetcode.firstUniqChar4(s));
	}

	public int firstUniqChar4(String s) {
//		int[] count = new int[26];// 存储各字符出现次数
		int[] count = new int[256];// 存储各字符出现次数
		int n = s.length();
		for (int i = 0; i < n; i++) {
			count[s.charAt(i)]++;
		}
		for (int i = 0; i < n; i++) {
			if (count[s.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;// 无解
	}

	public int firstUniqChar(String s) {
		int[] count = new int[26];// 存储各字符出现次数
		int n = s.length();
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < n; i++) {
			if (count[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;// 无解
	}

	public int firstUniqChar2(String s) {
		int[] count = new int[26];// 存储各字符出现次数
		for (char c : s.toCharArray())// 第一次遍历
			count[c - 'a']++;
		for (int i = 0; i < s.length(); i++) {// 第二次遍历
			if (count[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;// 无解
	}

	public int firstUniqChar3(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < n; i++) {
			if (count.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

}
