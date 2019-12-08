# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明:
#
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
#
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/merge-sorted-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


#####  思路1 暴力求解，将nums1的数组拷贝出来，nums1设置为空数组，然后循环遍历比较nums1.copy跟nums2的每个元素的大小，小的放进nums1中，
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        nums3 = nums1[:m]   #### 将数组1 拷贝出来
        nums1[:] =[]        #####  将数组1 设为空数组
        i,j = 0,0
        while i < m and j <n:
            if nums3[i] <= nums2[j]:
                nums1.append(nums3[i])    #######第一次写的时候nums1.append()  写错了，写成了nums1.append()=nums3[i]
                i += 1
            else:
                nums1.append(nums2[j])
                j += 1
        if i < m:                        ######### 由于nums1 与 nums2 容量不等，不要忘记将后续的不需要比较的已经排好序的数值加入
            nums1[i+j:] = nums3[i :]
        if j < n:
            nums1[i+j:] = nums2[j :]

