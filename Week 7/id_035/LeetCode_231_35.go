package day27

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:首先要搞清楚什么是2的冥次方、在数学中很好理解、但在二进制中应该怎么表示?
	实际就是n的二进制有且仅有一个"1", 即可满足n是2的冥次方
	所以仍然可以用n&(n - 1)进行判断
	只要n&(n - 1)=0、那么n就一定是一个2的冥次方
*/
func isPowerOfTwo(n int) bool {
	return n > 0 && n&(n - 1) == 0
}
//leetcode submit region end(Prohibit modification and deletion)

/*
	思路2:如果只用数学来看
	n不断除以2、所得的商必须是偶数或者为1
*/
func isPowerOfTwo2(n int) bool {
	if n == 0 {
		return false
	}
	if n == 1 {
		return true
	}
	if n % 2 != 0 {
		return false
	}
	for n != 0 {
		n = n / 2
		if n != 1 && n % 2 != 0 { // 得到了一个非1的奇数
			return false
		}
	}
	return true
}