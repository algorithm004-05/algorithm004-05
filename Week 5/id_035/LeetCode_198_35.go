package main

import "fmt"

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2:
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:动态规划
	根据题义、我们可以取下标i表示要偷的房子a[i]
	一般情况下:a[i] = a[i - 1] + nums[i]
	但这里需要注意的是、不能偷连续的两个房子、如果a[i - 1]偷过了
	a[i]就不能偷了、所以这里需要分两种情况考虑、因此需要升维、变成一个
	二维数组、a[i][j],其中j表示第i间房子是偷了还是没偷、用0、1表示
	subproblem: f(i) = sub(f(i - 1) + nums[i])/ sub(f(i - 1)
	dp array: 存储每个房子能偷到的最大金额以及是否要偷该房子的标记
	dp:a[i][0] = max(a[i - 1][0], a[i - 1][1])
	   a[i][1] = a[i - 1][0] + nums[i]
	时间复杂度:O(n)
*/
func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	a := make([][2]int, len(nums))
	a[0][0] = 0
	a[0][1] = nums[0]
	for i := 1; i < len(nums); i++ {
		a[i][0] = _max_amount(a[i - 1][0], a[i - 1][1])
		a[i][1] = a[i - 1][0] + nums[i]
	}
	return _max_amount(a[len(nums) - 1][0], a[len(nums) - 1][1])
}
/*
	思路2:动态规划优化
	前面的空间复杂度是O(n)的、但这里实际上我们只需要一个存储每一次能偷到的最大金额的数组
	所以这里我们的a可以改为[1][2]int、每次替换到i能偷到的最大金额即可、
	空间复杂度降为O(1_
*/
func rob2(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	a := [1][2]int{}
	a[0][0] = 0
	a[0][1] = nums[0]
	for i := 1; i < len(nums); i++ {
		tmp := a[0][0]
		a[0][0] = _max_amount(a[0][0], a[0][1])
		a[0][1] = tmp + nums[i]
	}
	return _max_amount(a[0][0], a[0][1])
}

/*
	思路3:动态规划优化
	subproblem:f(i - 1) + nums[i]
	dp array:存储i的最大值
	todo 核心:如果i-1必选、i就不能选、如果i-1没选、就可以加上nums[i]
	dp: a[i] = max(a[i - 1], a[i - 2] + nums[i])
*/
func rob3(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	a := make([]int, len(nums))
	a[0] = nums[0]
	a[1] = _max_amount(nums[0], nums[1])
	for i := 2; i < len(nums); i++ {
		a[i] = _max_amount(a[i - 1], a[i - 2] + nums[i])
	}
	return a[len(a) - 1]
}
func _max_amount(a int, b int) int {
	if a > b {
		return a
	} else  {
		return b
	}
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	fmt.Println(rob3([]int{2,1,1,2}))
}