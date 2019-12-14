package main

func main() {

}
func plusOne(digits []int) []int {
	plus := 1
	lens := len(digits)
	for i := lens - 1; i >= 0; i-- {
		digits[i] += plus
		if digits[i] < 10 {
			return digits
		}

		digits[i] = 0
	}

	return append([]int{1}, digits...)
}
