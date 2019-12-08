package id_035
/*
	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

	示例:

	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]
	说明:

	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。
*/
func moveZeroesSecond(nums []int)  {
	/*
		1. 给定一个变量j、存储不为0的元素
		2. 以i为下标遍历数组,将每一个遍历的元素与0比较、如果不为0、与j进行交换
		3. 判断i是否等于j，如果不等于，将下标i的元素置0(其实就是交换)
		4. j右移1位
	*/
	var j int = 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[j], nums[i] = nums[i], nums[j]
			if i != j {
				nums[i] = 0
			}
			j++ // 这一步很重要
		}
	}

	/*
		双指针法
		1. 设定两个下标,fast, slow
		2. fast相当于快指针、正常遍历
		3. slow相当于慢指针、在nums[fast]!=0时与nums[fast]进行交换、然后遍历
	*/
	fast, slow := 0, 0
	for fast < len(nums) {
		if nums[fast] != 0 {
			nums[fast], nums[slow] = nums[slow], nums[fast]
			slow++
		}
		fast++
	}
}

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



