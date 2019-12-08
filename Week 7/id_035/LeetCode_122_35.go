package main

import "golang.org/x/tools/go/ssa/interp/testdata/src/fmt"

//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//
//
// 示例：
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:计数排序
	给定一个额外的长度为1001的数组:arr_mem记录arr1中每个数组元素出现的次数、arr1中的每个元素为arr_mem的下标
	遍历arr2,检查每个元素是否存在于arr_mem中、如果存在、根据次数进行遍历、
	将下标追加到目标数组中
	最后遍历arr_mem、将所有元素值不为0的下标追加到目标数组后面
	注意:这里因为是将arr1中的元素当成了arr_mem中的下标进行处理、所以已经天然排好了序、
	最后对于不在arr2中的元素、不需要再单独排序
	时间复杂度:O(n^2)
*/
func relativeSortArray(arr1 []int, arr2 []int) []int {
	arr_mem := make([]int, 1001)
	target_arr := make([]int,0)
	for i := 0; i < len(arr1); i++ {
		arr_mem[arr1[i]]++
	}
	for i := 0; i < len(arr2); i++ {
		for arr_mem[arr2[i]] > 0 {
			target_arr = append(target_arr, arr2[i])
			arr_mem[arr2[i]]--
		}
	}
	for i := 0; i < len(arr_mem); i++ {
		for arr_mem[i] > 0 {
			target_arr = append(target_arr, i)
			arr_mem[i] --
		}
	}
	return target_arr
}
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	arr2 := []int{}
	arr1 := []int{}
	fmt.Println(relativeSortArray(arr1, arr2))
}