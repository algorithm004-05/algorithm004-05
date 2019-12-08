package main

import "fmt"

func main() {
	fmt.Println(isPowerOfTwo(100))
}

func isPowerOfTwo(n int) bool {
	return n > 0 && n&(n-1) == 0
}
