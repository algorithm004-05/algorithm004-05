package main

import "fmt"

func main() {
	bills := []int{
		5, 5, 10, 20, 20,
	}
	res := lemonadeChange(bills)
	fmt.Println(res)
}

func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for _, v := range bills {
		if v == 5 {
			five++
		} else if v == 10 {
			if five > 0 {
				five--
				ten++
			} else {
				return false
			}
		} else {
			if five > 0 && ten > 0 {
				five--
				ten--
			} else if five >= 3 {
				five -= 3
			} else {
				return false
			}
		}
	}
	
	return true
}
