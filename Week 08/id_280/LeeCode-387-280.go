func firstUniqChar(s string) int {
	cache := [26]int{}
	for _, l := range s {
		cache[l-'a']++
	}

	for i := range s {
		if cache[s[i]-'a'] == 1 {
			return i
		}
	}

	return -1
}