package day03
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
// 你可以假设数组中不存在重复的元素。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 示例 1:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//
//
// 示例 2:
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:二分查找 TODO 提交出错
	先找到旋转的坐标、然后再以此为界进行二分查找
	查找旋转坐标:只要找到数组中既小于左边、又小于右边的坐标、即可以此分界
*/
func search(nums []int, target int) int {
	mid_idx := _getIndex(nums)
	l_left := 0
	l_right := mid_idx - 1
	for l_left < l_right {
		mid := l_left + (l_right - l_left + 1) / 2
		if nums[mid] == target {
			return mid
		}  else if nums[mid] > target {
			l_right = mid - 1
		} else {
			l_left = mid + 1
		}
	}
	r_left := mid_idx
	r_right := len(nums) - 1
	for r_left < r_right {
		mid := r_left + (r_right - r_left + 1) / 2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			r_right = mid - 1
		} else {
			r_left = mid + 1
		}
	}
	return -1
}

func _getIndex(nums []int) int {
	left := 0
	right := len(nums) - 1
	for left < right {
		mid := left + (right - left + 1) / 2 // 找中位数
		if nums[mid] < nums[left] {
			return mid
		} else {
			right = mid - 1
		}
	}
	return 0
}
//leetcode submit region end(Prohibit modification and deletion)

/*
	思路2:二分查找、优化:因为数组经过了旋转、所以它的最小值和最大值都已经不在边界上
	中间值mid可以和target进行比较、但这里紧紧只比较中间值还不行、需要将当前的左右边界都
	包含进来
	左边界:left
	右边界:right
	比较mid和left的大小、如果mid>left说明左边是单调递增的、如果mid<left说明mid右边是单调递增的
*/
func search2(nums []int, target int) int {
	left := 0
	right := len(nums) - 1

	for left < right {
		mid := left + (right - left + 1) / 2
		if nums[mid] == target {
			return mid
		}
		if (nums[mid] > nums[left] && (target > nums[mid] ||
			(target < nums[mid] && target < nums[left]))) ||
			(nums[mid] < nums[left] && target > nums[mid] && target <= nums[right]){
			// target在右边
			left = mid
		} else {
			// target在左边
			right = mid - 1
		}
	}
	if left == right && nums[left] == target{
		return left
	}
	return -1
}