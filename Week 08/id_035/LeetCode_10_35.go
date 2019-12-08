package main

import "fmt"

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3:
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4:
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5:
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false
// Related Topics 字符串 动态规划 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:回溯
	判断s和p长度是否相等、如果相等、判断s和p的第一个字符是否相等或者p此处的字符是否为点号
	如果不相待、判断p中是否有*、如果没有返回false、如果有则判断s中此处的字符是否和前一个字符相等
*/
func isMatch(s string, p string) bool {
	return _is_match(s, p)
}

func _is_match(s string, p string) bool {
	// terminal
	if len(p) == 0 {
		return len(s) == 0
	}
	first := len(s) != 0 && (s[0] == p[0] || p[0] == '.')
	if len(p) >= 2 && p[1] == '*' {
		// 发现*
		// drill down
		return _is_match(s, p[2:]) || (first && _is_match(s[1:], p))
	} else if first {
		// drill down
		return _is_match(s[1:], p[1:])
	}
	return false
}

/*
	思路2:动态规划
	sub problem: f(i,j) = f(i-1,j-1)&&s[i]==p[j]||p[j] == "." || ...
	dp array:存储s[i]和p[j]是否匹配
	dp: 在dp[i - 1][j - 1]满足匹配条件的情况下、dp需要分情况考虑
	1. s[i] == p[i]||p[i] == "."
	2. len(p)>=2&&p[i] == "*"
	todo 核心逻辑未写完
*/
func isMatch2(s string, p string) bool {
	ls := len(s)
	lp := len(p)

	dp := make([][]bool, ls)
	for i := 0; i < lp; i++ {
		dp[i] = make([]bool, lp)
	}

	for i := 0; i <= ls; i++ {
		for j := 0; j <= lp; j++ {

		}
	}
	return dp[ls - 1][lp - 1]
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	s := ""
	p := "."
	fmt.Println(isMatch2(s, p))
}
