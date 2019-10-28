package main

import (
	"fmt"
	"sort"
)

func main() {
	testcase := [...]string{"eat", "tea", "tan", "ate", "nat", "bat"}
	fmt.Println(groupAnagrams(testcase[:]))
}

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)
	for _, str := range strs {
		key := getKey(str)
		groups[key] = append(groups[key], str)
	}

	ret := make([][]string, 0, len(groups))
	for _, v := range groups {
		ret = append(ret, v)
	}
	return ret
}

func getKey(str string) string {
	b := []byte(str)
	sort.Slice(b, func(i, j int) bool {
		return b[i] < b[j]
	})
	return string(b)
}