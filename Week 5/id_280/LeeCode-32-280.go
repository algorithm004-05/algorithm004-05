package main

import "fmt"

func main() {

	str  := "(()"
	fmt.Println(longestValidParentheses(str))
}

func longestValidParentheses(s string) int {
	if len(s) == 0 {
		return 0
	}
	n, left, max := len(s), 0, 0
	d := make([]int, n)

	for i := 0; i < n; i++ {
		if s[i] == '(' {
			left++
		} else if left > 0 {
			d[i] = d[i-1] + 2
			if i-d[i] > 0 {
				d[i] += d[i-d[i]]
			}
			max = Max(max, d[i])
			left--
		}
	}

	return max
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}