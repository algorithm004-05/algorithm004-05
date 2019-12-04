package main

import "fmt"

func bubbleSort(arr []int) []int {
	for i := 0; i < len(arr)-1; i++ {
		for j := 1; j < len(arr)-i; j++ {
			if arr[i] > arr[j] {
				// arr[j], arr[i] = arr[i], arr[j]
				temp := arr[j]
				arr[j] = arr[i]
				arr[i] = temp
			}
		}
	}
	return arr
}

func main() {
	arr := []int{1, 3, 2, 7}
	fmt.Println(bubbleSort(arr))
}
