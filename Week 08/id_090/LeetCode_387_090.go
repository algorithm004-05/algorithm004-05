package main

import "fmt"

func main() {
	s := "abcaaaa"
	fmt.Println(firstUniqChar(s))
}

func firstUniqChar(s string) int {
	lens := len(s)

	if lens <= 0 {
		return -1
	}
	m := make(map[uint8]int, lens)

	for i := range s {
		m[s[i]]++
	}

	for i := range s {
		if m[s[i]] == 1 {
			return i
		}
	}

	return -1
}
