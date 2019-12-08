package id_035

/*
  要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
  思路1:暴力破解,遍历，删除重复元素
  时间复杂度:O(n)
*/

func removeDuplicates(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}
	i := 1
	for i < len(nums){
		if nums[i] == nums[i - 1] {
			nums = append(nums[:i - 1],nums[i:]...)
		} else {
			i++
		}
	}
	return len(nums)
}

/*
  思路2:双指针(找不同值)
  定义两个指针fast,slow. fast= 1, slow = 0,进行遍历判断。如果nums[fast]!=nums[slow],将nums[fast]覆盖到slow+1处，直到fast遍历完成
  时间复杂度:O(n)
*/

func removeDuplicates2(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}
	fast, slow := 1, 0
	for fast < len(nums) {
		if nums[fast] != nums[slow] {
			nums[slow + 1] = nums[fast]
			slow++
		}
		fast++
	}
	nums = nums[:slow + 1]
	return len(nums)
}


/*
  思路3:双指针优化
  根据思路2，如果数组本身就是一个不重复的数组、会产生不必要的原地覆盖、所以可以进行优化
  主要优化思想为，如果nums[fast] != nums[slow],判断fast和slow是否相邻，如果相邻就不用管、不相邻再进行判断
*/
func removeDuplicates3(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}
	fast, slow := 1, 0
	for fast < len(nums) {
		if nums[fast] != nums[slow] {
			if fast - slow > 1 {
				nums[slow + 1] = nums[fast]
			}
			slow++
		}
		fast++
	}
	nums = nums[:slow + 1]
	return len(nums)
}



