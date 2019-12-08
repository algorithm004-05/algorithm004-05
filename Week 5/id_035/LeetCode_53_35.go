package main

import "fmt"

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:分治、因为必须要是连续子数组、所以可以从最后一个开始判断,sum(i)应该是
	sum(i-1)与0之间的最大值+a[i]、在子数组中不包含a[i-1]时取0
	子问题:sum(i) = max(sum(i-1), 0)+a[i]
	todo 重点:最大连续子序列和 = 当前元素自身最大，或者包含之前后最大
	状态数组:f[i]
	DP方程:f[i] = _max(f[i - 1], 0) + a[i]
*/
func maxSubArray(nums []int) int {
	max_sum := nums[0]
	for i := 1; i < len(nums); i++ {
		nums[i] = _max(nums[i], nums[i] + nums[i - 1])
	}
	for i := 1; i < len(nums); i++ {
		max_sum = _max(max_sum, nums[i])
	}
	return max_sum
}

func _max(a int, b int) int {
	if a > b {
		return a
	} else  {
		return b
	}
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	s := []int{-2,1,-3,4,-1,2,1,-5,4}
	fmt.Println(maxSubArray(s))
}