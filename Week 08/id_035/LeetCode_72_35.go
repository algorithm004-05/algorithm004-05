package main

import "fmt"

//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
// 示例 1:
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2:
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
// Related Topics 字符串 动态规划

/*
	思路1:动态规划
	升维
	给定一个二维数组dp[i][j]
	i:word1的数组字符
	j:word2的数组字符
	如果word1[i]==word2[j]则可以打掉这两个字符、继续判断i-1,j-1
	如果word1[i]!= word2[j]则要做相应处理
	dp[i-1][j-1]+1:将最后一个字符置于相等(replace)、然后打掉、但因为做了一次操作、所以需要+1
	dp[i-1][j]+1:word1删掉一个字符
	dp[i][j-1]+1:word2删掉一个字符
	取上面三者最小值
	sub problem := f(i,j) = f(i-1,j-1)...
	dp array: 存储当前字符相等时的最小操作数
	dp:
		word1[i] == word2[j]:dp[i][j] = dp[i - 1][j - 1]
		word1[i]!= word2[j]: dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1, dp[i - 1][j] + 1)
	时间复杂度:O(n^2)
*/
//leetcode submit region begin(Prohibit modification and deletion)
func minDistance(word1 string, word2 string) int {
	if len(word1)*len(word2) == 0 {
		return _max(len(word1), len(word2))
	}
	dp := make([][]int, len(word1)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(word2)+1)
		// 左边界赋值
		dp[i][0] = i
	}
	// 下边界赋值
	for i := 0; i < len(word2)+1; i++ {
		dp[0][i] = i
	}
	for i := 0; i < len(dp); i++ {
		fmt.Println(dp[i])
	}
	// 输入: word1 = "horse", word2 = "ros"
	for i := 0; i < len(word1); i++ {
		for j := 0; j < len(word2); j++ {
			if word1[i] == word2[j] {
				dp[i+1][j+1] = dp[i][j]
			} else {
				dp[i+1][j+1] = _min(_min(dp[i][j], dp[i][j+1]), dp[i+1][j]) + 1
			}
		}
	}
	return dp[len(dp)-1][len(dp[0])-1]
}

func _max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}

func _min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	w1 := "distance"
	w2 := "springbok"
	fmt.Println(minDistance(w1, w2))
}
