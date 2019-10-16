package main

import "fmt"

//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例:
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
// Related Topics 数组 双指针

// 第二遍 2019年10月15日
//leetcode submit region begin(Prohibit modification and deletion)
func maxArea(height []int) int {
	// 从两边向中间靠拢
	var i int = 0
	var j int = len(height) - 1
	var maxArea int = 0
	for i < j {

		h := 0
		if height[i] < height[j] {
			h = height[i]
			i++
		} else {
			h = height[j]
			j--
		}

		area := h * (j - i + 1)
		if area > maxArea {
			maxArea = area
		}
	}

	return maxArea
}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	d := []int{2, 3, 4, 5, 18, 17, 6}
	fmt.Println(maxArea(d))

}
