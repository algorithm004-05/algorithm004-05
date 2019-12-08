package main

import "fmt"

//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
// 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
//
// 给定 N，计算 F(N)。
//
//
//
// 示例 1：
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
//
//
// 示例 2：
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
//
//
// 示例 3：
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//
//
// 提示：
//
//
// 0 ≤ N ≤ 30
//
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:递归+记忆搜索
	根据fib数列的特性、可以采用递归的方法、但只采用递归的话、
	其时间复杂度是指数级的、所以可以采用递归+记忆搜索的方法、
	时间复杂度为O(n)
*/
func fib(N int) int {
	slice := make([]int, N + 1)
	return _fib_helper(N, &slice)
}

func _fib_helper(n int, slice *[]int) int {
	// terminal
	if n <= 1 {
		return n
	}
	// current logic process
	if (*slice)[n] == 0 {
		// drill down
		(*slice)[n] = _fib_helper(n - 1, slice) + _fib_helper(n - 2, slice)
	}
	return (*slice)[n]
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:采用bottom_up、自底向上的方法
	前面的思路采用了自顶向下的方法、也就是从n开始推导、
	这里我们可以从1开始推导、直接通过一次循环解决
*/
func fib2(N int) int {
	if N <= 1 {
		return N
	}
	// 因为第一个数是0、也就是s[0]=0
	// 而数组是以下标为索引、所以必须是N+1
	// 否则会造成越界
	slice := make([]int, N + 1)
	slice[0] = 0
	slice[1] = 1
	for i := 2; i <= N; i++ {
		slice[i] = slice[i - 1] + slice[i - 2]
	}
	return slice[len(slice) - 1]
}
func main() {
	fmt.Println(fib2(3))
}