package main

import (
	"fmt"
	"strconv"
)

func main() {
	s := "12" 
	fmt.Println(numDecodings(s))
}

func numDecodings(s string) int {
	if len(s) == 0 || s[0] == '0' {
		return 0
	}
	magic := make([]int, len(s)+1)
	magic[0], magic[1] = 1, 1
	for i := 2; i < len(s)+1; i++ {
		if s[i-1] != '0' {
			magic[i] += magic[i-1]
		}
		if s[i-2] != '0' {
			if v, _ := strconv.Atoi(s[i-2:i]); v <= 26 {
				magic[i] += magic[i-2]
			}
		}
	}
	return magic[len(s)]
}
