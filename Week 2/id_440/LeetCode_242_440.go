package leetcode

import (
	"sort"
	"strings"
)

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	s1:=strings.Split(s,"")
	t1:=strings.Split(t,"")
	sort.Strings(s1)
	sort.Strings(t1)
	s=strings.Join(s1,"")
	t=strings.Join(t1,"")
	return strings.Compare(s, t) == 0
}
