package main

func main() {

}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums))
	
	for index1, num := range nums {
		index2, exists := m[target-num]
		if exists {
			return []int{index1, index2}
		}
		m[num] = index1
	}
	
	return []int{}
}