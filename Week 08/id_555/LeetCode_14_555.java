package lsn20_string;

/**
 * 14. 最长公共前缀
 * 
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * https://www.imooc.com/read/44/article/729
 */
public class LeetCode_14_555 {

	public static void main(String[] args) {
		LeetCode_14_555 leetcode = new LeetCode_14_555();
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(leetcode.longestCommonPrefix(strs));
		System.out.println(leetcode.longestCommonPrefix2(strs));
		System.out.println(leetcode.longestCommonPrefix3(strs));
		System.out.println(leetcode.longestCommonPrefix4(strs));
		
		String str1 = "flower";
		String str2 = "flight";
		int i = str1.indexOf(str2);
		System.out.println(i);
	}

	public String longestCommonPrefix4(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++) {
			// 第 0 个字符不需要比较，可以直接从第 1 个字符开始进比较
			for (int j = 1; j < strs.length; j++) {
				// 只要strs中存在比当前长度i更短的string，立刻返回上一轮LCP，即strs[0][:i]
				// 只要strs中存在当前index字符与LCP该index不相同的字符串，立刻返回上一轮LCP，即strs[0][:i]
				if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0]; // 如果一直没返回，说明strs[0]本身就是LCP，返回它
	}

	public String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		// 最长字串的长度一定不会超过第 0 个字符串的长度
		int end = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			while (j < end && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			end = j;
		}
		return strs[0].substring(0, end);
	}

	/**
	 * 水平扫描法
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
