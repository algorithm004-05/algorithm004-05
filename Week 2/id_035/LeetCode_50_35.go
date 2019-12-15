package main

import "fmt"

//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:原始递归
	计算 x 的 n 次幂函数相当于x*x(^(n-1))、所以直接采用递归的方法
	逻辑没有问题、但如果输入的小数很少以及冥太大、会导致内存溢出
*/
func myPow(x float64, n int) float64 {
	// 终止条件
	if 0 == n {
		return 1
	}
	// 执行逻辑
	if n > 0 {
		// 进入下一层
		res := x * myPow(x, n - 1)
		return res
	} else {
		res := 1 / x * myPow(x, n + 1)
		return res
	}

}

/*
	思路1:递归优化(分治)
	前面写了原始递归的方式、这里会导致溢出、可以做一个优化
	x^2n = x^n * x^n、和上一种方法不同之处在于、这里我们相当于采用了二分法、每次计算它的一半结果
	只需要执行O(logn)、而上面的时间复杂度是O(n)的
	这里可以做一个奇偶性判断
	假设A=x^(n/2)
	n为奇数,结果应该是A*A*x
	n为偶数,结果应该是A*A
*/
func myPow2(x float64, n int) float64 {
	// 终止条件
	if 0 == n {
		return 1
	}
	if n < 0 {
		x = 1 / x
		n = -1 * n
	}
	if n % 2 == 0 {
		// (split you big problem)
		half := myPow(x, n /2 )
		// merge
		return half * half
	} else {
		// 进入下一层
		// merge
		half := myPow(x, n /2 )
		return half * half * x
	}
}

/*
	思路1:递归再优化优化
	在思路2中、时间复杂度我们已经做得比较好了、这里考虑一下空间复杂度、
	和前面的递归一样、将已经计算过的数据保存起来、在下次计算的时候、如果已存在、直接返回即可
*/
func _helper(x float64, n int, m map[int]float64) float64 {
	// 终止条件
	if 0 == n {
		return 1
	}
	if _, ok := m[n]; ok {
		return m[n]
	}
	if n < 0 {
		x = 1 / x
		n = -1 * n
	}
	// 执行逻辑()
	if n % 2 == 0 {
		// 进入下一层
		half := _helper(x, n /2, m)
		m[n / 2] = half
		return half * half
	} else {
		// 进入下一层
		half := _helper(x, n /2, m)
		m[n / 2] = half
		return half * half * x
	}
}

func myPow3(x float64, n int) float64 {
	m := make(map[int]float64)
	return _helper(x, n, m)
}
//leetcode submit region end(Prohibit modification and deletion)
func main() {
	fmt.Println("myPow(2, -2):", myPow(2, -2))
}