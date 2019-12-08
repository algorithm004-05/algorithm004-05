package leetcode

func minDistance(word1 string, word2 string) int {
	//定义状态dp[i][j]
	n := len(word1)
	m := len(word2)
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
		//数组的(n-1,m-1)对应dp存储的(n,m)
	}
	// 默认值
	for i := 0; i <= n; i++ {
		dp[i][0] = i
	}
	for j := 0; j <= m; j++ {
		dp[0][j] = j
	}
	//DP方程
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]))
			}

		}
	}
	return dp[n][m]
}

func min(m, n int) int {
	if m <= n {
		return m
	} else {
		return n
	}
}
