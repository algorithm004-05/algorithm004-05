package main

func main() {

}

//接雨水
/***
 * 思路 1、i点的可存水量为 左右最矮高度 减去当前高度
 * min(max(height[:i+1]...), max(height[i:])) - height[i]
 * 2、关键点在找到左右最大高度
 */

func bigger(a, b int) int {
	if a > b {
		return a
	}

	return b
}

func smaller(a, b int) int {
	if a < b {
		return a
	}

	return b
}

func trap(height []int) int {
	lens := len(height)

	// 少于2个点则装不下水
	if lens <= 2 {
		return 0
	}

	left, right := make([]int, lens), make([]int, lens)

	// 初始化左右边界
	left[0], right[lens-1] = height[0], height[lens-1]

	for i := 1; i < lens; i++ {
		left[i] = bigger(left[i-1], height[i])
		right[lens-1-i] = bigger(right[lens-i], height[lens-1-i])
	}

	water := 0
	for i := 0; i < lens; i++ {
		water += smaller(left[i], right[i]) - height[i]
	}

	return water
}
