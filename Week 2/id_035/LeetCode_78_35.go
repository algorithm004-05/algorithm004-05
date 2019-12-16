package c78

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:遍历插入子集
	给定一个空数组、[]、遍历所有元素、在遍历到第i个元素时、将i放入空数组中、同时将i放入前面所有的已经生成的子集中
	// 将i放入空数组
	// 遍历前面所有元素、追加生成新的数组然后追加到result中
*/
func subsets(nums []int) [][]int {
	result := make([][]int, 0)
	result = append(result, []int{})

	/*
		注意、这里的里层循环只能用range,如果使用下标方式、会导致nums无限增加、
		但使用rage则不会、因为range实际上是对nums做了一个拷贝、它内部遍历的
		是nums_copy(nums的副本),而副本不会随着result增加无限增加
	*/
	//for i := 0; i < len(nums); i++{
	//	for j := 0; j < len(result); j++ {
	//		result = append(result, append(result[j], nums[i]))
	//	}
	//}

	for _, num := range nums {
		for _, res := range result {
			result = append(result, append(res, []int{num}...))
			result = append(result, append([]int{num},res...))
		}
	}
	return result
}

func subsets2(nums []int) [][]int {
	res := [][]int{[]int{}}
	for _, e := range nums {
		for _, ee := range res {
			res = append(res, append([]int{e}, ee...))
		}
	}
	return res
}
//leetcode submit region end(Prohibit modification and deletion)
