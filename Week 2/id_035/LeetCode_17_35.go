package c17

import "strings"

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:递归回溯
	从1开始、遍历、每个元素都对应相应字符、每遍历到一个、将字符添加到字符串中
*/
func letterCombinations(digits string) []string {
	// 初始化:将数字以及其对应字符存入map
	m := _initMap()
	result := make([]string, 0) // 最终结果字符串
	s := ""	// 每次拼接完成字符串
	next_digits := strings.Split(digits,"")
	_helper( next_digits, s, m, &result)
	return result
}

func _helper(digits []string, s string, map_set map[string]string, result *[]string) {
	// terminal
	if len(digits) == 0 {
		*result = append(*result, s)
		return
	}
	// process logic in current level
	for _, m := range map_set[digits[0]] {
		// drill down
		_helper(digits[1:], s+string(m), map_set, result)
	}

}

func _initMap() map[string]string {
	m := make(map[string]string)
	m["2"] = "abc"
	m["3"] = "def"
	m["4"] = "ghi"
	m["5"] = "jkl"
	m["6"] = "mno"
	m["7"] = "pqrs"
	m["8"] = "tuv"
	m["9"] = "wxyz"
	return m
}
//leetcode submit region end(Prohibit modification and deletion)

/*
	思路2:使用队列辅助
*/
func letterCombinations2(digits string) []string {
	// 初始化:将数字以及其对应字符存入map
	m := _initMap()
	queue := make([]string, 1) // 队列
	for len(digits) > 0 {
		size := len(queue)
		for size > 0 {
			for _, c := range m[string(digits[0])] {
				// a b c
				queue = append(queue, queue[0]+string(c))
			}
			queue = queue[1:]
			size--
		}
		digits = digits[1:]
	}
	return queue
}