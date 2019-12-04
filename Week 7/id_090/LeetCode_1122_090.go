package main

func main() {

}

//计数排序
func relativeSortArray(arr1 []int, arr2 []int) []int {
	m := make(map[int]int)
	res := []int{}

	for _, v := range arr1 {
		m[v]++
	}

	for _, v := range arr2 {
		for m[v] > 0 {
			res = append(res, v)
			m[v]--
		}
	}

	for i := 0; i <= 1000; i++ {
		if m[i] == 0 {
			continue
		}
		for m[i] > 0 {
			res = append(res, i)
			m[i]--
		}
	}

	return res
}
