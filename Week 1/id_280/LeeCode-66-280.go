package main

import "fmt"

func main() {
	var dd = [...]int{1,2,3}
	fmt.Println(plusOne(dd[:]))
}

func plusOne(digits []int) []int {
	n := len(digits)
	for i := n - 1; i >= 0; i-- {
		if digits[i] < 9 {
			digits[i] ++
			return  digits
		}
		digits[i] = 0
	}
	var newNumber []int
	newSize := n + 1
	newNumber = newNumber[:]
	for i := 0; i < newSize; i++ {
		newNumber = append(newNumber, 0)
	}
	newNumber[0] = 1

	return newNumber[:]
}