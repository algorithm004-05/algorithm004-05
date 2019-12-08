package main

func main() {

}

//计数
func isAnagram(s string, t string) bool {
	m := make(map[byte]int, len(s))
	sLen := len(s)
	tLen := len(t)
	for i := 0; i < sLen; i++ {
		m[s[i]]++
	}

	for j := 0; j < tLen; j++ {
		m[t[j]]--
	}

	for _, v := range m {
		if v != 0 {
			return false
		}
	}

	return true
}
