package main

import "fmt"

func main() {
	nums := [...]int{1,1,1,1,2,2,2,2,2,3,4,4,4,4,4,5,6,6,6,6,6,6}
	fmt.Println(removeDuplicates(nums[:]))
	fmt.Println(nums)
}

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	i := 0
	for j := 1; j < len(nums); j++ {
		if nums[j] != nums[i] {
			i++
			nums[i] = nums[j]
		}
	}
	return i + 1
}