package main

func main() {
	
}

func validPalindrome(s string) bool {
	i, j := 0, len(s) -1
	for i < j {
		if rune(s[i]) != rune(s[j]) {
			return check(s, i, j-1) || check(s, i+1, j)
		}
		i++
		j--
	}
	
	return true
}

func check(s string, i, j int) bool {
	for i < j {
		if rune(s[i]) != rune(s[j]) {
			return false
		}
		i++
		j--
	}
	return true
}
