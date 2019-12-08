package lsn05.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 49. 字母异位词分组
 * 
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 */
public class LeetCode_49_555 {

	public static void main(String[] args) {
		LeetCode_49_555 leetcode = new LeetCode_49_555();
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
//		List<List<String>> list = leetcode.groupAnagrams(strs);
		List<List<String>> list = leetcode.groupAnagrams2(strs);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	// 方法一：排序数组分类
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> ans = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList<String>());
			}
			ans.get(key).add(s);
		}
		return new ArrayList<List<String>>(ans.values());
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		if (strs.length == 0)
			return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

}
