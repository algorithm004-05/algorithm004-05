package Array

import "fmt"

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针

// 第二遍 2019年10月15日
//leetcode submit region begin(Prohibit modification and deletion)
func moveZeroes(nums []int) {
	j := 0
	for i, n := range nums {
		if n != 0 {
			nums[i], nums[j] = nums[j], nums[i]
			j++
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	nums := []int{0, 0, 1}
	moveZeroes(nums)
	fmt.Println(nums)
}
