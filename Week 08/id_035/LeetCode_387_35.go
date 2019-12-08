package main

import (
	"fmt"
)

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 案例:
//
//
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
//
//
//
//
// 注意事项：您可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串

//leetcode submit region begin(Prohibit modification and deletion)
/*
	给定一个map存储字符串中的每一个字符
	遍历数组、找到第一个在map中的数量不为1的字符、即是第一个不重复字符的索引
	时间复杂度:O(n）
	空间复杂度:O(n)
*/


func firstUniqChar(s string) int {
	set := make(map[string]int)
	for i := 0; i < len(s); i++ {
		set[string(s[i])]++
	}
	for i := 0; i < len(s); i++ {
		if set[string(s[i])] == 1 {
			return i
		}
	}
	return 0
}

func _min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}

/*
	思路2:给定一个长为26的数组、数组中存储每个字符的索引、所有数组元素初始化为-1
	然后遍历s、如果当前字符代表的下标元素为-1、则为其赋值索引index,否则置为-2
	遍历数组、找到最小的索引返回
*/
func firstUniqChar2(s string) int {
	set := [26]int{}
	for i := 0; i < len(set); i++ {
		set[i] = -1
	}
	// 将每一个不重复的字符赋上索引
	for i := 0; i < len(s); i++ {
		if set[s[i] - 'a'] == -1 {
			set[s[i] - 'a'] = i
		} else {
			set[s[i] - 'a'] = -2
		}
	}
	idx := len(s) + 1

	for i := 0; i < len(set); i++ {
		if set[i] >= 0 && idx > set[i]{
			idx = set[i]
		}
	}
	if idx == len(s) + 1 {
		return -1
	}
	return idx
}
//leetcode submit region end(Prohibit modification and deletion)
func main() {
	s := "llllsa"
	fmt.Println(firstUniqChar2(s))
}