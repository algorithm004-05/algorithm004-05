package main

import (
	"fmt"
)

func main() {
	fmt.Println(isAnagram("anagram", "nagaram"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	table := [26]int{}
	for i := 0; i < len(s); i++ {
		table[s[i]-'a']++
	}
	for i := 0; i < len(t); i++ {
		table[t[i]-'a']--
		if table[t[i]-'a'] < 0 {
			return false
		}
	}
	return true
}