package main

import (
	"fmt"
	"math"
)

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	暴力求解
	coins中n种面值的硬币、以1,2,5为例、需要的硬币数量应该是
	f(amount-1)+1, f(amount-2)+1, f(amount-3)+1的最小值
	所以、这里可以采用分治的方式、分解为子问题
	todo 超时
*/
func coinChange(coins []int, amount int) int {
	// terminal
	if amount == 0 {
		return 0
	}
	min := math.MaxInt64
	for _, coin := range coins {
		// current logic
		if coin >amount {
			continue
		}
		// drill down
		sub_pro := coinChange(coins, amount - coin)
		if sub_pro == -1 {
			continue
		}
		// 取当前最小值和所得子问题结果的最小值+1的较小值
		min = _min(min, sub_pro + 1)
	}
	if min == math.MaxInt64 {
		return -1
	}
	return min
}

/*
	思路2:递归+记忆化搜索
	将已经得到最小数量的coin存起来
*/
func coinChange2(coins []int, amount int) int{
	mem := make([]int, amount+1)
	// 因为计算结果中包含了0和-1、所以这里选择初始化为-2
	for i := 0; i < len(mem); i++ {
		mem[i] = -2
	}
	return _helper_coin_change(coins, amount, mem)
}

func _helper_coin_change(coins []int, amount int, mem []int) int {
	min := math.MaxInt64
	if mem[amount] != -2 {
		return mem[amount]
	}
	// terminal
	if amount == 0 {
		return 0
	}
	// current logic
	for _, coin := range coins {
		if coin > amount {
			continue
		}
		// drill down
		sub_pro := _helper_coin_change(coins, amount - coin, mem)
		if sub_pro == -1 {
			continue
		}
		min = _min(min, sub_pro + 1)
	}
	if min == math.MaxInt64 {
		mem[amount] = -1
		return mem[amount]
	}
	mem[amount] = min
	return mem[amount]
}

func _min(pre int, aft int) int {
	if pre > aft {
		return aft
	} else {
		return pre
	}
}
//leetcode submit region end(Prohibit modification and deletion)

/*
	思路3:动态规划、将递归的办法改成递推的办法
	设置d[S]表示凑成金额S的最小硬币数
	todo 核心要点:对于任意面值x、其凑成金额S的最小硬币数应该为min(d[S-x]+1)
	时间复杂度:O(n^2)
*/
func coinChange3(coins []int, amount int) int {
	// sub problem:problem(amount) = sub(amount - x) + 1
	// 动态数组:存储凑成金额amount的最小硬币数
	// DP方程:dp[i] = min(dp[i], dp[amount - coins[i] + 1)
	dp := make([]int, amount + 1)
	// 注意:这里不能赋值成int64的最大值、int默认为32
	for i := 1; i < amount + 1; i++ {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0
	for i := 1; i < amount + 1;i++ {
		for _, coin := range coins {
			if i < coin {
				continue
			}
			dp[i] = _min(dp[i], dp[i - coin] + 1)
		}
	}
	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}
func main() {
	coins := []int{186,419,83,408}
	amount := 6249
	fmt.Println(coinChange2(coins, amount))
}