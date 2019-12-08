package main

import (
	"fmt"
	"math"
)

//请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
// 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
// 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
// 说明：
//
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//
// 示例 1:
//
// 输入: "42"
//输出: 42
//
//
// 示例 2:
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//
//
// 示例 3:
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//
//
// 示例 4:
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。
//
// 示例 5:
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
//     因此返回 INT_MIN (−231) 。
//
// Related Topics 数学 字符串

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:暴力法:遍历字符串、先去掉前面可能存在的空格字符、
	然后检查每一个字符是否是数字、或者其它符号、做对应处理
	难点:如何判断一个字符是不是数字 0-9
	时间复杂度:O(n)
*/
func myAtoi(str string) int {
	new_str := ""
	// 去掉空格字符
	for i := 0; i < len(str); i++ {
		if str[i] != ' ' {
			new_str = str[i:]
			break
		}
	}
	if len(new_str) == 0 {
		return 0
	}
	// 纪录正负号
	pg := ""
	if new_str[0] == '+' || new_str[0] == '-' {
		pg = string(new_str[0])
		new_str = new_str[1:]
	} else if new_str[0] < '0' && new_str[0] > '9' {
		return 0
	}

	new_new_str := ""
	// 截取数字
	for i := 0; i < len(new_str); i++ {
		if new_str[i] >= '0' && new_str[i] <= '9' {
			new_new_str += string(new_str[i])
		} else {
			break
		}
	}
	if len(new_new_str) == 0 {
		return 0
	}

	var data int64 = 0
	var sign int64 = 1

	if pg == "-" {
		sign = -1
	}
	// 纯数字
	for i := 0; i < len(new_new_str); i++ {
		if sign*(data*10+int64(new_new_str[i]-'0')) > math.MaxInt32 {
			return math.MaxInt32
		}
		if sign*(data*10+int64(new_new_str[i]-'0')) < math.MinInt32 {
			return math.MinInt32
		}

		data = data*10 + int64(new_new_str[i]-'0')
	}

	data = sign * data
	if data >= math.MinInt32 && data <= math.MaxInt32 {
		return int(data)
	} else if data > math.MaxInt32 {
		return math.MaxInt32
	} else {
		return math.MinInt32
	}
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	// 8446744073709551617
	// 9223372036854775808
	//fmt.Println(8446744073709551617 - math.MaxInt64)
	fmt.Println(myAtoi("  8446744073709551617"))
}
