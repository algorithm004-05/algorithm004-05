package leetcode

import (
	"math"
	"strconv"
	"strings"
)

func myAtoi(str string) int {
	num := 0
	s := ""
	flag := false
	str = strings.TrimSpace(str)
	if len(str) == 0 {
		return 0
	}
	for i := 0; i < len(str); i++ {
		if !(str[i] >= '0' && str[i] <= '9') && !(str[i] == '+' || str[i] == '-') {
			break
		}
		if str[i] == '+' {
			if flag || s != "" {
				break
			}
			flag = true
			continue
		}
		if str[i] == '-' {
			if flag || s != "" {
				break
			}
			flag = true
			s += "-"
			continue
		}
		s += string(str[i])
	}
	num, _ = strconv.Atoi(s)
	if num > math.MaxInt32 {
		return math.MaxInt32
	} else if num < math.MinInt32 {
		return math.MinInt32
	}
	return num
}
