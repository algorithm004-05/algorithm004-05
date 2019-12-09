package main

func main() {
	
}

//暴力
func majorityElement(nums []int) int {
	m := make(map[int]int)
	mLen := len(nums)
	for _, v := range nums {
		m[v]++
		if m[v] > mLen /2 {
			return v
		}
	}
	return 0
}