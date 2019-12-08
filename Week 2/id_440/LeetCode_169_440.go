package leetcode

func majorityElement(nums []int) int {
	count, currentNum := 0, 0
	for _, v := range nums {
		if count == 0 {
			currentNum = v
			count++
		} else if currentNum == v {
			count++
		} else {
			count--
		}
	}
	return currentNum
}
