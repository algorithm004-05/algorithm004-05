func search(nums []int, target int) int {
    left := 0
    right := len(nums) - 1

        for left < right {
            mid := (left + right) / 2
            if nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]) {
                left = mid + 1
            } else if target > nums[mid] && target < nums[0] {
                left = mid + 1
            } else {
                right = mid
            }
        }
    if left == right && nums[left] == target {
        return left
    }
        return  -1;
}