package lsn20_string;

import java.util.Arrays;
import java.util.Collections;

/**
 * 151. 翻转字符串里的单词
 * 
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 */
/**
 * 1 split, reverse, join
 * 
 * 2 reverse整个String，然后单独reverse每个单词
 *
 */
public class LeetCode_151_555 {

	public static void main(String[] args) {
		LeetCode_151_555 leetcode = new LeetCode_151_555();
		String s = "the sky is  blue";
		System.out.println(leetcode.reverseWords(s));
	}

	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		System.out.println(Arrays.toString(words));
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
}
