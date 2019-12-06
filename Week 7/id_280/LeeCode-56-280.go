package main
 
func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		 return [][]int{}
	 }
	 merged := make([][]int, 0, len(intervals))
	 sort.Slice(intervals, func(i, j int) bool {
		 return intervals[i][0] < intervals[j][0]
	 })
	 current := intervals[0]
	 for i := 1; i < len(intervals); i++ {
		 if intervals[i][0] > current[1] {
			 merged = append(merged, current)
			 current = intervals[i]
		 } else if intervals[i][1] > current[1] {
			 current[1] = intervals[i][1]
		 }
	 }
	 merged = append(merged, current)
	 return merged
 }