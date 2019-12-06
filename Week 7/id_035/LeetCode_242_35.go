package main

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表


/*
	思路1:哈希表
	遍历s、将s中的每一个字符存入map、key代表字符、value代表出现次数、做次数累加
	遍历t、将t中的字符与map中进行对比、做次数递减
	最后遍历map、检查map中的每个字符数量是否都是0、如果是则表示t是s的异位词
*/
//leetcode submit region begin(Prohibit modification and deletion)
func isAnagram(s string, t string) bool {
	m := make(map[byte]int)
	for _, s1 := range s {
		m[byte(s1)]++
	}
	for _, t1 := range t {
		m[byte(t1)]--
	}
	for _, val := range m {
		if val != 0 {
			return false
		}
	}
	return true
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:直接对s和t进行排序、然后检查s和t是否相等
	核心思路:排序方法
*/
func isAnagram2(s string, t string) bool {
	if _order(s) == _order(t) {
		return true
	}
	return false
}
/*
	排序1:快速排序、s变成数组、取中间点mid、将小于mid的值放左边
	大于mid的值放右边、继续对左边和右边的数组进行排序
*/
func _order(s string) string {
	var arr []byte = make([]byte, len(s))
	for _, s1 := range s {
		arr = append(arr, byte(s1))
	}
	_quick_sort(arr, 0, len(arr) - 1)
	return string(arr)
}

func _quick_sort(arr []byte, begin, end int)  {
	if begin >= end {
		return
	}
	// current logic
	//mid := (begin + end) >> 1
	mid := _partition1(arr, begin, end)
	// drill down
	_quick_sort(arr, begin, mid - 1)
	_quick_sort(arr, mid + 1, end)
}
func _partition1(arr []byte, l int, r int) int {
	p := l
	j := p + 1
	for i := l + 1; i <= r; i++ {
		if arr[i] < arr[p] {
			arr[i], arr[j] = arr[j], arr[i]
			j++
		}
	}
	arr[p], arr[j - 1] = arr[j - 1], arr[p]
	return j - 1
}