package partical

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:递归求解
	首先这个人一次最多只能爬两级、也可以爬一级
	也就是说、他要到第n级台阶时、可以剩一步(n - 1 + 1)、也可以剩两步(n - 2 + 2)
	剩一步的方法有f(n-1)种、剩两步的方法有f(n-2)种、所以应该是f(n - 1)+f(n - 2)
	注意:如果n过大、会超出时间限制

*/
func climbStairs(n int) int {
	if n <= 2 {
		return n
	}
	return climbStairs(n - 1) + climbStairs(n - 2)
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路1:递归求解(优化)
	上面的思路会超出时间限制、也就是说我们直接把递归写"傻"了、这里可以考虑使用缓存
	需要考虑的时、如何使用缓存可以减少递归的次数，这里我们可以很明显的发现、有很多中间层
	的函数都执行了多次、比如在求解f(4)的时候 f(4)=f(3)+f(2), f(3)=f(2)+f(1)...,这里f(2)就调用了两次
	所以可以考虑从这里入手、看看能不能通过合理使用缓存有效减少中间函数的调用次数
	将已经计算过的数存在数组中
*/
func climbStairs2(n int) int {
	if n <= 2 {
		return n
	}
	slice := make([]int, n + 1)
	return climb_stairs(n, n, slice)
}

func climb_stairs(i, n int, slice []int) int {
	if i <= 2 {
		slice[i] = i
	}
	// 如果数组中已经存在对应值:直接返回
	if slice[i] > 0 {
		return slice[i]
	}
	slice[i] = climb_stairs(i - 1, n, slice) + climb_stairs(i - 2, n, slice)
	return slice[i]
}


/*
	思路3:直接累加
*/
func climbStairs3(n int) int {
	if n <= 2 {
		return n
	}
	f1 := 1
	f2 := 2
	f3 := 3
	for i := 3; i < n + 1; i++ {
		f3 = f1 + f2
		f1 = f2
		f2 = f3
	}
	return f3
}