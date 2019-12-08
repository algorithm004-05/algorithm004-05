package main

func main() {
	
}

func countSubstrings(s string) int {
	lens := len(s)
	
	//默认多长就有多少个字串
	result := lens
	for i := 0; i < lens; i++ {
		for j := 1; i+j < lens && i-j >= 0 && s[i+j] == s[i-j]; j++ {
			result++
		}
		
		for j := 1; i+j < lens && i-j+1 >= 0 && s[i+j] == s[i-j+1]; j++ {
			result++
		}
		
	}
	
	return result
}

