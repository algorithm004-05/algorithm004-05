package main

import (
	"fmt"
	"strings"
)

//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串


/*
	思路1: 将字符串直接通过字符拆分成数组、直接求最后一个数组元素的长度
*/
//leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLastWord(s string) int {
	slice := strings.Split(s, " ")
	fmt.Println(slice)
	for i := len(slice) - 1; i >= 0; i-- {
		if slice[i] != "" {
			return len(slice[i])
		}
	}
	return 0
}
/*
	思路2:标记、给定一个标记空格的变量resetCount
	遍历s、如果遍历到的字符是空格、resetCount = true
	如果不是空格、判断当前遍历的字符是否是单词的第一个字母、如果是 count重置为0
	resetCount置为false
	如果不是直接count+1
*/
func lengthOfLastWord2(s string) int {
	var count int
	var resetCount bool

	for _, c := range s {
		fmt.Println(string(c))
		if c == ' ' {
			resetCount = true
		} else {
			// 检查是否是单词的第一个字母
			if resetCount {
				count = 0
				resetCount = false
			}
			count++
		}
	}

	return count
}
//leetcode submit region end(Prohibit modification and deletion)
func main() {
	fmt.Println(lengthOfLastWord2("hello world moon"))
}