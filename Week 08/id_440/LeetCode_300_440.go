package leetcode

func lengthOfLIS(nums []int) int {
	lenght := len(nums)
	if lenght < 2 {
		return lenght
	}

	dp := make([]int, lenght)
	dp[0] = 1

	maxans := 1
	for i := 1; i < lenght; i++ {
		dp[i] = 1
		for j := i - 1; j >= 0; j-- {
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		maxans = max(maxans, dp[i])
	}
	return maxans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
