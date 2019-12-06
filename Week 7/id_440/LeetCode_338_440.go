package leetcode

func countBits(num int) []int {
	rs := make([]int, num+1)
	rs[0] = 0
	for i := 1; i <= num; i++ {
		rs[i] = rs[i&(i-1)] + 1
	}
	return rs
}
