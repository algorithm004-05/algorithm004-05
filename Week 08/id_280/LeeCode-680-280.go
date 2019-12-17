 
func validPalindrome(s string) bool {
    r := len(s) - 1
    for i:=0;i<len(s);i++ {
        if s[i] != s[r] {
            return isBool(s, i+1, r) || isBool(s, i, r-1)
        }
        r--
    }
    return true
}

func isBool (s string, l int, r int) bool {
    for l < r {
        if s[l] != s[r] {
            return false;
        }
        l++
        r--
    }
    return true
}
 