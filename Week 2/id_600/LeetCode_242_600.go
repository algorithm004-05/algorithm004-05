func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    
    arr := make([]int, 26)
    
    for _, ch := range []rune(s) {
        arr[ch - 'a']++
    }
    
    for _, ch := range []rune(t) {
        if arr[ch - 'a'] == 0 {
            return false
        }
        
        arr[ch - 'a']--
    } 
    
    for _, val := range arr {
        if val != 0 {
            return false
        }
    }
    
    return true
}