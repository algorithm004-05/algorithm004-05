package main

import (
	"fmt"
)

//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:动态规划、与c53思路基本相似
	但是因为是乘积、又存在负数、所以需要考虑负负得正的情况
	所以这里应该有两个dp数组、一个存到当前为止最大的子序列积，
	一个存到当前为止最小的子序列积、每次在出现负数的时候:
		max(f(i)) = _max(nums[i], imin[i - 1]*nums[i])
		min(f(i)) = _min(nums[i], nums[i] * imax[i - 1])
*/
func maxProduct(nums []int) int {
	// sub_problem :f(i) =  _max(f(i-1)*nums[i], nums[i])
	// dp_array:存储当前下标所代表的最大子序列积
	// dp:dp[i] = _max(dp[i - 1]*nums[i], nums[i]
	dp_max := make([]int, len(nums))
	dp_min := make([]int, len(nums))
	dp_max[0] = nums[0]
	dp_min[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] >= 0 {
			dp_max[i] = _max_pro(nums[i], nums[i] * dp_max[i - 1])
			dp_min[i] = _min_pro(nums[i], nums[i] * dp_min[i - 1])
		} else {
			dp_max[i] = _max_pro(nums[i], nums[i] * dp_min[i - 1])
			dp_min[i] = _min_pro(nums[i], nums[i] * dp_max[i - 1])
		}
	}
	max := dp_max[0]
	for i := 1; i < len(dp_max); i++ {
		max = _max_pro(max, dp_max[i])
	}
	return max
}

func _max_pro(a int, b int) int {
	if a > b {
		return a
	} else  {
		return b
	}
}

func _min_pro(a int, b int) int {
	if a > b {
		return b
	} else  {
		return a
	}
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:优化、前面我们用了一个dp数组来存储每个下标对应的最大子序列积、
	这里我们可以只用两个值imax, imin分别维护每个下标的最大值和最小值、再使用一个变量max来接收到目前为止的最大值
*/
func maxProduct2(nums []int) int {
	max, imax, imin := nums[0],nums[0],nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] < 0 {
			imax, imin = imin, imax
		}
		imax = _max_pro(nums[i], imax * nums[i])
		imin = _min_pro(nums[i], imin * nums[i])
		max = _max_pro(max, imax)
		fmt.Println("max:", max)
	}
	return max
}
func main() {
	fmt.Println(maxProduct([]int{-2,0,1}))
}