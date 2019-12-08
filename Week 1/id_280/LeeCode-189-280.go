package main

import "fmt"

func main() {
	nums := [...]int{1,2,3,4,5,6,7}
	rotate(nums[:], 3)
	fmt.Println(nums)
}

func rotate(nums []int, k int)  {
	k %= len(nums)
	reverse(nums, 0, len(nums) - 1)
	reverse(nums, 0, k - 1)
	reverse(nums, k, len(nums) - 1)
}
func reverse(nums []int, start int, end int)  {
	for ;start < end; {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}