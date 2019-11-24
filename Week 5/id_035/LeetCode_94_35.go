package main

import (
	"fmt"
	"strings"
)

//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划
/*
	思路1:动态规划
	根据题义:可以设置dp[i]为s[0,i]的解码总数
	因为最大值是26、所以对于i来说、最多可以获取前面两位
	根据推导:dp[i] = dp[i - 1] + dp[i - 2]
	上面公式的由来:如果将i处字符单独插进去、其实和前一位i-1相比、解法并没有增加、仅仅是在解码的后面添加了一个字母
	如果将i处字符与i-1处字符组合、则是和i-2处相比、解法没有增加、而是在i-2的每个解码结果后面插入了该字符的解码结果
	子问题:f(i) = f(i - 1) + f(i - 2)
	dp array: 存储到当前字符为止的解法数量
	dp 方程: dp[i] = dp[i - 1] + dp[i - 2]
	注意:这里有一些特殊情况需要判断
		i = '0':
		此时因为i无法解码、所以不能单独插入、只能与前一个字符组合、
		如果前一个字符大于2，则不能解码, dp[i] = dp[i - 1]
		如果前一个字符也为0、则该数字字符串不能解码
		如果前一个字符小于2但不为0、则dp[i] = dp[i - 2]
		i != 0:
		如果前一个字符大于2或者等于0，只能单独解码, dp[i] = dp[i - 1]
		如果前一个字符是1或者2、则dp[i] = dp[i - 1] + dp[i - 2]
		如果当前字符大于6、则前一个字符只能是1、否则无法解码
*/
//leetcode submit region begin(Prohibit modification and deletion)
func numDecodings(s string) int {
	slice := strings.Split(s, "")
	dp := make([]int, len(slice)+1)
	// 初始化dp[0]
	dp[0] = 1
	if slice[0] == "0" {
		// 字符头不能为0、否则无法解码该字符
		return 0
	} else {
		dp[1] = 1
	}

	for i := 1; i < len(slice); i++ {
		if slice[i] != "0" {
			if (slice[i - 1] == "1") || (slice[i - 1] == "2" && s[i] - 48 <= 6) {
				dp[i + 1] = dp[i] + dp[i - 1]
			} else {
				dp[i + 1] = dp[i]
			}
		} else {
			if slice[i - 1] == "1" || slice[i - 1] == "2" {
				dp[i + 1] = dp[i - 1]
			} else {
				return 0
			}
		}
	}
	return dp[len(dp) - 1]
}
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(numDecodings("22623"))
}