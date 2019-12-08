package day03

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 请找出其中最小的元素。
//
// 你可以假设数组中不存在重复元素。
//
// 示例 1:
//
// 输入: [4,6,1,2,3]
// 1,2
//输出: 1
//
// 示例 2:
//
// 输入: [3,5,1]
//输出: 0
// Related Topics 数组 二分查找


/*
	思路1:二分查找
	mid>right:左边递增、找右边
	mid<right:右边递增、找左边
*/
//leetcode submit region begin(Prohibit modification and deletion)
func findMin(nums []int) int {
	left := 0
	right := len(nums) - 1
	for left < right {
		mid := left + (right - left) / 2
		if nums[mid] > nums[left] {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return nums[left]
}
//leetcode submit region end(Prohibit modification and deletion)
