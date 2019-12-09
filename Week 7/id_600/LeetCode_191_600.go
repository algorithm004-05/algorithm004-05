func hammingWeight(num uint32) int {
    times := 0
	for ; num != 0; times++ {
		num &= num - 1
	}
	return times
}