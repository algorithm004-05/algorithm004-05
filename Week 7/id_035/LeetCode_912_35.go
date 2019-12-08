package main

//给定一个整数数组 nums，将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：[5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：[5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// -50000 <= A[i] <= 50000
//
//


/*
	思路1:快速排序
*/
//leetcode submit region begin(Prohibit modification and deletion)
func sortArray(nums []int) []int {
	_quick_sort1(nums, 0, len(nums) - 1)
	return nums
}
//leetcode submit region end(Prohibit modification and deletion)
func _quick_sort1(arr []int, begin, end int)  {
	// terminal
	if begin >= end {
		return
	}
	// current logic
	//mid := (begin + end) >> 1
	mid := _partition(arr, begin, end)
	// drill down
	_quick_sort1(arr, begin, mid - 1)
	_quick_sort1(arr, mid + 1, end)
}

// 分区、返回基准索引p、使得arr[l:p - 1] < arr[p] && arr[p + 1: r] > arr[p]
func _partition(arr []int, l int, r int) int {
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