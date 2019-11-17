package day01
//  https://leetcode-cn.com/problems/jump-game-ii/
// 给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:贪心算法、正向、首先指定一个目标位置
	从数组头部开始遍历、找到最远的能够跳到指定位置的下标(第一个能够跳转的下标)、
	然后切换目标位置为当前下标、重复上面的操作走到位置变为0
	时间复杂度:O(n^2)
	空间复杂度:O(1)
*/
func jump(nums []int) int {
	target := len(nums) - 1
	step_count := 0
	for target > 0 {
		for i := 0; i < len(nums); i++ {
			if nums[i] + i >= target {
				target = i
				step_count++
				break
			}
		}
	}
	return step_count
}
