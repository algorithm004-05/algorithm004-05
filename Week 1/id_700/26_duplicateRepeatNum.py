# 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
#
# 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


###  思路 双指针法，运用i,j指针，用i记录非重复的值的下标，返回数组长度i+1, 删除零的类似体型


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for j in range(len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]
        return i +1

####  总结：
# 1. 这一题与283删除零的题型类似，双指针法，记录不重复的数值的下标，用下标j来遍历数组，使用额外的空间nums[i]来记录下一个要比较的值，额外空间为O（1）
# 2. 我在这道题中常犯的错误是：不记得借助额外的空间nums[i]记录比较数值，单纯的运用下标nums[j+1]与nums[j]对比，进而导致j循环中，无法解决指针溢出的问题。
