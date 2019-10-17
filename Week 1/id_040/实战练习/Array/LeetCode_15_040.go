package Array

import (
	"fmt"
	"sort"
)

// 第二遍 2019年10月16日
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针

//leetcode submit region begin(Prohibit modification and deletion)
func threeSum(nums []int) [][]int {
	rdata := make([][]int, 0)
	sort.Ints(nums)

	for k := 0; k < len(nums)-2; k++ {
		i := k + 1
		j := len(nums) - 1

		if nums[k] > 0 {
			break
		}

		if k > 0 && nums[k] == nums[k-1] {
			continue
		}

		for i < j {
			sum := nums[k] + nums[i] + nums[j]
			if sum == 0 {
				rdata = append(rdata, []int{nums[k], nums[i], nums[j]})

				i++
				j--

				for i < j && nums[i] == nums[i-1] {
					i++
				}

				for i < j && nums[j] == nums[j+1] {
					j--
				}
			} else if sum < 0 {
				i++
				for i < j && nums[i] == nums[i-1] {
					i++
				}
			} else if sum > 0 {
				j--
				for i < j && nums[j] == nums[j+1] {
					j--
				}
			}
		}
	}

	return rdata

}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	nums := []int{-1, 0, 1, 2, -1, -4}

	fmt.Println(threeSum(nums))

}
