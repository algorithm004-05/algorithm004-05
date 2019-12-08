package main

import "sort"

func main() {
	
}

type IntSlice []int

func (s IntSlice) Less(i, j int) bool {
	return s[i] < s[j]
}
func (s IntSlice) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s IntSlice) Len() int {
	return len(s)
}

func findContentChildren(g []int, s []int) int {
	sort.Sort(IntSlice(g))
	sort.Sort(IntSlice(s))
	
	result := 0
	
	gLen := len(g)
	sLen := len(s)
	
	gIndex, sIndex := 0, 0
	
	for gIndex < gLen && sIndex < sLen {
		if g[gIndex] <= s[sIndex] {
			gIndex++
			result++
		}
		sIndex++
	}
	
	return result
}