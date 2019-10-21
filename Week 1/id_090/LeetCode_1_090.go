package main

func main() {

}

func twoSum(nums []int, target int) []int {
	var m = make(map[int]int, len(nums))

	for idx1, num := range nums {
		idx2, exists := m[target-num]
		if exists {
			return []int{idx1, idx2}
		}

		m[num] = idx1
	}

	return []int{}
}
