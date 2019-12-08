func twoSum(nums []int, target int) []int {
	if len(nums) < 2 {
		return nil
	}
	
    maps := make(map[int]int)
    
    for index, value := range nums {
        anotherNum := target - value
        
        if _, v := maps[anotherNum]; v {
            return []int{index, maps[anotherNum]}
        }
        maps[value] = index
    }
    
    return nil
}