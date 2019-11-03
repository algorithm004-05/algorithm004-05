package main

import "fmt"

func main() {
	intest := [...]int{123}
	fmt.Println(permute(intest[:]))
}

func permute(nums []int) [][]int {
	var result [][]int
	var path []int
	visited := make([]bool, len(nums))
	result = helper(result, path, nums, visited)

	return result
}

func helper(result [][]int, path []int, nums []int, visited []bool) [][]int {
	if len(path) == len(nums) {
		copyOfNums := make([]int, len(path))
		copy(copyOfNums, path)
		result = append(result, copyOfNums)
		return result
	}

	for i := 0; i < len(nums); i++ {
		if !visited[i] {
			path = append(path, nums[i])
			visited[i] = true
			result = helper(result, path, nums, visited)
			path = append(path[:len(path)-1], path[len(path):]...)
			visited[i] = false
		}
	}

	return result
}