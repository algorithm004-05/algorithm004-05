package main

import "fmt"

func main() {
	in := [...]int{2,3,1,1,4}
	fmt.Println(canJump(in[:]))
}

func canJump(nums []int) bool {
	if len(nums) == 0 {
		return false
	}
	endReachAble := len(nums) - 1
	for i := endReachAble; i >= 0; i-- {
		if nums[i] + i >= endReachAble { 
			endReachAble = i
		}
	}
	return endReachAble == 0
}