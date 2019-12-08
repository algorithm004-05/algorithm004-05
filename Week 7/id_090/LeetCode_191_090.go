package main

import "fmt"

func main() {
	fmt.Println(hammingWeight(00000000000000000000000000001011))
}

func hammingWeight(num uint32) int {
	counter := 0

	for num != 0 {
		counter++
		num &= (num - 1)
	}

	return counter
}
