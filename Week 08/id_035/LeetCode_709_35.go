package main

import (
	"fmt"
)

//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//
//
// 示例 1：
//
//
//输入: "Hello"
//输出: "hello"
//
// 示例 2：
//
//
//输入: "here"
//输出: "here"
//
// 示例 3：
//
//
//输入: "LOVELY"
//输出: "lovely"
//
// Related Topics 字符串


/*
	思路1:直接减去字符'a'
	注意需要先判断当前字母是否是大宝字母
	时间复杂度:O(n)
	空间复杂度:O(n)
*/
//leetcode submit region begin(Prohibit modification and deletion)
func toLowerCase(str string) string {
	lowerStr := ""
	for _, s := range str {
		if  s >= 65 && s <= 90 {
			// 大写字母
			lowerStr += string(s + 32)
		} else {
			lowerStr += string(s)
		}
	}
	return lowerStr
}
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(toLowerCase("al&phaBET"))
	fmt.Println('a' - '&')
}