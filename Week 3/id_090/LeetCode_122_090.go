package main

import "fmt"

func main() {
	profit := maxProfit([]int{1, 10, 20, 1, 22, 33})
	fmt.Println(profit)
}

func maxProfit(prices []int) int {
	profit := 0

	for k := range prices {
		if k == 0 {
			continue
		}
		if prices[k] > prices[k-1] {
			profit += prices[k] - prices[k-1]
		}
	}

	return profit
}
