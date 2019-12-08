func maxArea(height []int) int {
    max := 0
    i := 0
    j := len(height) - 1
    
    for ;i < j; {
        minHeight := 0
        if height[i] < height[j] {
            minHeight = height[i]
            i ++
        } else {
            minHeight = height[j]
            j --
        }
        area := minHeight * (j - i + 1)
        
        if area > max {
            max = area
        }
    }
    
    return max
}