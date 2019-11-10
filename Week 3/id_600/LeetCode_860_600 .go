func lemonadeChange(bills []int) bool {
	perCount := map[int]int{
		5:  0,
		10: 0,
	}
	for _, v := range bills {
		if v == 5 {
			perCount[5]++
		} else if v == 10 {
			if perCount[5] > 0 {
				perCount[5]--
				perCount[10]++
			} else {
				return false
			}
		} else {
			if perCount[10] > 0 {
				perCount[10]--
				if perCount[5] > 0 {
					perCount[5]--
				} else {
					return false
				}
			} else {
				if perCount[5] >= 3 {
					perCount[5] = perCount[5] - 3
				} else {
					return false
				}
			}
		}
	}
	return true
}