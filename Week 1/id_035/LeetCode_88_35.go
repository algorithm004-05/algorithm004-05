package id_035

import "sort"

/*
	给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

	说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	示例:
	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	输出: [1,2,2,3,5,6]
*/

/*
	思路1:直接追加、重新排序
	时间复杂度:取决于数组排序的时间复杂度
*/
func merge(nums1 []int, m int, nums2 []int, n int)  {
	nums1 = nums1[:m]
	nums1 = append(nums1, nums2...)
	sort.Ints(nums1)
}

/*
	思路2:插入法
	遍历nums2的每个元素，将其插入nums1中合适的位置
	时间复杂度:O(n^2)
	todo 没有成功
*/

func merge2(nums1 []int, m int, nums2 []int, n int)  {
	nums1 = nums1[:m]
	for i := 0; i < len(nums2); i++ {
		if nums2[i] >= nums1[len(nums1)-1] {
			nums1 = append(nums1, nums2[i])
		} else {
			for j := 0; j < len(nums1) - 1; j++ {
				if nums2[i] > nums1[j] && nums2[i] <= nums1[j+1]{
					// 插入
					nums := append(nums1[:j+1],nums2[i])
					nums1 = append(nums,nums1[j+1:]...)
				}
			}
		}
	}
}

/*
	思路3:双指针
	给一个额外的数组存储nums1
	p1作为nums1的指针
	p2作为nums2的指针
	一边遍历一边比较，将最小的值放入nums1中
	时间复杂度:O(n)
*/

func merge3(nums1 []int, m int, nums2 []int, n int)  {
	nums := make([]int, 0)
	p1, p2 := 0, 0
	for p1 < m && p2 < n {
		if nums1[p1] <= nums2[p2] {
			nums = append(nums, nums1[p1])
			p1++
		} else  {
			nums = append(nums, nums2[p2])
			p2++
		}
	}

	// 如果还有元素没有插入
	if p1 < m {
		nums = append(nums, nums1[p1:]...)
	}
	if p2 < n {
		nums = append(nums, nums2[p2:]...)
	}
	// 由于golang的slice的引用属性、这里只能用copy、不能直接赋值
	copy(nums1, nums)
}
