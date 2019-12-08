package main

func main() {

}

/**
* 双指针解法
* 1、j负责标记0的位置
*2、i负责移动，当遇到非0的数字，判断i与j的位置，如果不等，则交换且移动j，否则单单移动j即可
*/
func moveZeroes(nums []int) {
	if len(nums) == 0 {
		return
	}

	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			if i != j {
				nums[i], nums[j] = nums[j], nums[i]
				j++
			} else {
				j++
			}
		}
	}
}
