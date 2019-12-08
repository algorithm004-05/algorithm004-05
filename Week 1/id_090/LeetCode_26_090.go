package main

func main() {

}

/*
 * 快慢指针解法
 */
func removeDuplicates(nums []int) int {
	i := 0
	lens := len(nums)

	for j := 1; j < lens; j++ {
		if nums[j] != nums[i] {
			i++
			nums[i] = nums[j]
		}
	}

	return i + 1
}
