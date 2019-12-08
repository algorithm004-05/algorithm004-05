package main

import (
	"fmt"
	"math"
)

//数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
//
// 示例 1:
//
//
//输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
//
//
// 示例 2:
//
//
//输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
//
//
// 注意：
//
//
// cost 的长度将会在 [2, 1000]。
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
//
// Related Topics 数组 动态规划

/*
	思路1:动态规划、这里和前面的求爬楼梯方法是一样的、但需要注意的是、这里的顶层应该在len(cost)处、而不是cost的最后一个下标
	sub problem: f(i) = min(f(i - 1), f(i - 2)) + cost[i]
	dp array:每个下标i所指向的元素表示爬到当前位置所消耗的最小体力值
	dp : dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])
*/
//leetcode submit region begin(Prohibit modification and deletion)
func minCostClimbingStairs(cost []int) int {
	cost = append(cost, 0)
	dp := make([]int, len(cost))
	dp[0] = cost[0]
	dp[1] = cost[1]
	for i := 2; i < len(cost); i++ {
		dp[i] = cost[i] + int(math.Min(float64(dp[i-1]), float64(dp[i-2])))
	}
	return dp[len(dp)-1]
}

//leetcode submit region end(Prohibit modification and deletion)

/*
	思路2:动态规划、对上一个做简化
*/
func minCostClimbingStairs2(cost []int) int {
	for i := 2; i < len(cost); i++ {
		cost[i] = _min(cost[i-1], cost[i-2]) + cost[i]
	}
	return _min(cost[len(cost)-2], cost[len(cost)-1]) // 如果走到了最后一步、就加上最后一步、如果走到的是倒数第二步
	// 消耗的体力就是倒数第二步、取最小值
}

func _min(i, j int) int {
	if i > j {
		return j
	}
	return i
}

/*
	思路3:动态规划、空间复杂度优化
*/

func minCostClimbingStairs3(cost []int) int {
	f1 := cost[0]
	f2 := cost[1]
	//f0 := 0
	for i := 2; i < len(cost); i++ {
		//f0 = cost[i] + _min(f1, f2)
		//f1 = f2
		//f2 = f0
		// 最简洁的写法如下
		f1, f2 = f2, cost[i] + _min(f1, f2)
	}
	return _min(f1, f2)
}

func main() {
	fmt.Println(minCostClimbingStairs3([]int{0,1,1,0}))
}
