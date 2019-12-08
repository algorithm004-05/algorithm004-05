package main

import "fmt"

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划

/*
	思路1:动态规划
	sub problem: f(i) = max(f(0),...,f(i - 1)) + 1
	dp array: 存储到下标i处的最长上升子序列、这里要注意的是、每个dp元素所代表的最长子序列可能不只一个、所以需要找到最大的那个
	dp: dp[i] = max(dp[0],...,dp[i-1]) + 1
*/
//leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLIS(nums []int) int {
	length := len(nums)
	if length <= 1 {
		return length
	}
	dp := make([]int, length)
	dp[0] = 1
	max := 1
	for i := 1; i < length; i++ {
		max_val := 0
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				max_val = _max(dp[j], max_val)
			}
		}
		dp[i] = max_val + 1
		// 找最长子序列
		max = _max(max, dp[i])
	}
	return max
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	nums := []int{4, 10, 4, 3, 8, 9}
	fmt.Println(lengthOfLIS(nums))
}
