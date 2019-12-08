package main

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
/*
	问题点:什么是回文子串? 指这个字符串无论从左读还是从右读,所读的顺序是一样的
	思路1: 动态规划
	定义一个二维数组、dp[i][j]、i和j分别表示字符串的起点和终点。
	sub problem: f(i,j) = f(i + 1, j - 1) && s[i] == s[j]
	dp array: 表示当前从i到j的字符串是否是回文子串
	dp: dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
	给定res表示当前最长回文子串
	只要dp[i][j]为真就表示当前子串是回文串、如果j - i + 1 > res.length、则说明i->j的子串是最长回文子串
*/
func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}
	res := ""
	l := len(s)
	dp := make([][]bool, l)
	for i := 0; i < l; i++ {
		dp[i] = make([]bool, l)
	}

	for i := l - 1; i >= 0; i-- {
		for j := i; j < l; j++ {
			// todo 注意后面的顺序不能乱、否则可能会造成越界
			dp[i][j] = (s[i] == s[j]) && (j-i < 2 || dp[i+1][j-1])
			if dp[i][j] && j-i+1 > len(res) {
				res = s[i : j+1]
			}
		}
	}
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
