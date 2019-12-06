package main
 
func hammingWeight(n int) int {
	sum := 0
	for n != 0 {
		sum++
		n &= n - 1
	}
	return sum
}
