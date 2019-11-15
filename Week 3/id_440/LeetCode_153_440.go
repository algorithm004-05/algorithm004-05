package leetcode

func findMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}

	if len(nums) == 1 {
		return nums[0]
	}

	left, right := 0, len(nums)-1

	for {
		if left == len(nums)-1 {
			return nums[0]
		}
		if nums[left] < nums[left+1] {
			left += 1
		} else {
			return nums[left+1]
		}
		if nums[right-1] < nums[right] {
			right -= 1
		} else {
			return nums[right]
		}
	}
}
