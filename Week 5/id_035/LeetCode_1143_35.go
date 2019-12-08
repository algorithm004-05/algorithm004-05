package main

//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
// 若这两个字符串没有公共子序列，则返回 0。
//
//
//
// 示例 1:
//
// 输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//
//
// 示例 2:
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//
//
// 示例 3:
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
//
//
//
//
// 提示:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// 输入的字符串只含有小写英文字符。
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:动态规划
	判断两个字符串最后一个字符是否相等、如果相等、就等于它们前一个字符串
	的最长子序列加1、如果不相等、就等于二者分别减去一个字符之后的最长子序列的最大值
*/
func longestCommonSubsequence(text1 string, text2 string) int {
	m := len(text1)
	n := len(text2)
	if m == 0 || n == 0 {
		return 0
	}
	// 初始化一个二维数组存放每个字符最长子序列长度
	array := make([][]int, m + 1)
	for i := 0; i < m + 1; i++ {
		array[i] = make([]int, n + 1)
	}
	// 判断
	for i := 1; i < m + 1; i++ {
		for j := 1; j < n + 1; j++ {
			if text1[i - 1] == text2[j - 1] {
				array[i][j] = array[i - 1][j - 1] + 1
			} else {
				array[i][j] = _max_length(array[i][j - 1] , array[i - 1][j])
			}
		}
	}
	return array[m][n]

}

func _max_length(s1_len int, s2_len int) int {
	if s1_len > s2_len {
		return s1_len
	} else {
		return s2_len
	}
}


//leetcode submit region end(Prohibit modification and deletion)
