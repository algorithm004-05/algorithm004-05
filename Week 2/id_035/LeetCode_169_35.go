package c169

//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:暴力--将每个元素出现的次数存入map、最后进行遍历统计
	时间复杂度:O(n)
	空间复杂度:O(n)
*/
func majorityElement(nums []int) int {
	if nil == nums {
		return 0
	}
	m_ele := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		m_ele[nums[i]]++
	}
	for key, val := range m_ele {
		if val > len(nums) / 2 {
			return key
		}
	}
	return 0
}

/*
	思路2:摩尔投票法

	设置两个变量 candidate 和 count，candidate 用来保存数组中遍历到的某个数字，count 表示当前数字的出现次数，一开始 candidate 保存为数组中的第一个数字，count 为 1
	遍历整个数组
	如果数字与之前 candidate 保存的数字相同，则 count 加 1
	如果数字与之前 candidate 保存的数字不同，则 count 减 1
	如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
	遍历完数组中的所有数字即可得到结果

	时间复杂度:O(n)
*/
func majorityElement2(nums []int) int {
	if len(nums) == 0{
		return 0
	}
	if len(nums) == 1{
		return nums[0]
	}

	candidate := nums[0]
	count := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] == candidate {
			count++
		} else {
			count--
			if count == 0 {
				candidate = nums[i]
				count = 1
			}
		}
	}
	return candidate
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路3:分治
*/
func majorityElement3(nums []int) int {
	if nil == nums {
		return 0
	}
	if len(nums) == 1{
		return nums[0]
	}
	return 0
}