package main

import "sort"

//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组

/*
	思路1: 排序+一次扫描
	1. 按照左界对intervals进行排序
	2. 从第二个区间开始遍历、如果遍历到的区间左界小于或者等于前面已有的区间的右界、则需要合并、否则直接追加
	3. 排序方式采用快排
	时间复杂度:O(nlogn)+O(n) = O(n)
*/
//leetcode submit region begin(Prohibit modification and deletion)
func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return nil
	}
	result := make([][]int, 0)
	_quick_sort(intervals, 0, len(intervals)-1)
	tmp_arr := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= tmp_arr[1] {
			tmp_arr[1] = _max(intervals[i][1], tmp_arr[1])
		} else {
			result = append(result, tmp_arr)
			tmp_arr = intervals[i]
		}
	}
	result = append(result, tmp_arr)
	return result
}

func _max(a int, b int) int {
	if a >= b {
		return a
	}
	return b
}

func _quick_sort(intervals [][]int, l int, r int) {
	// terminal
	if l >= r {
		return
	}
	// current logic
	p := _partition(intervals, l, r)
	// dirll down
	_quick_sort(intervals, l, p-1)
	_quick_sort(intervals, p+1, r)
}

func _partition(intervals [][]int, l int, r int) int {
	p := l
	j := p + 1
	for i := l + 1; i < len(intervals); i++ {
		if intervals[i][0] < intervals[p][0] {
			intervals[j], intervals[i] = intervals[i], intervals[j]
			j++
		}
	}
	intervals[p], intervals[j-1] = intervals[j-1], intervals[p]
	return j - 1
}

//leetcode submit region end(Prohibit modification and deletion)

/*
	思路2:采用系统自带的排序进行处理
*/
func merge2(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return nil
	}
	result := make([][]int, 0)
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	tmp_arr := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] > tmp_arr[1] {
			result = append(result, tmp_arr)
			tmp_arr = intervals[i]
		} else if intervals[i][1] > tmp_arr[1] {
			tmp_arr[1] = intervals[i][1]
		}

	}
	result = append(result, tmp_arr)
	return result
}
func main() {
	intervals := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
	_quick_sort(intervals, 0, len(intervals)-1)
}
