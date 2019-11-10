package leetcode

func lemonadeChange(bills []int) bool {
	if bills[0] != 5 {
		return false
	} else {
		five, ten := 0, 0
		for _, v := range bills {
			if v == 5 {
				five++
			} else if v == 10 {
				if five == 0 {
					return false
				}
				five--
				ten++
			} else {
				if five > 0 && ten > 0 {
					five--
					ten++
				} else if five >= 3 {
					five -= 3
				} else {
					return false
				}
			}

		}
		return true
	}
}
