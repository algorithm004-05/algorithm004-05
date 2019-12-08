# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
# 示例:
#
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
# 说明:
#
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/move-zeroes
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

######  思路：双指针法，用i记录非零值的下标，遍历数组，当遇到非零的时候，以i做记录，并将i增加1
######        当出现下标i,j不一致时，表明数组中已经出现零的，而这个零值需要被替换到j上，此时将nums[j]=0，

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i] = nums[j]
                if j != i:
                    nums[j] = 0
                i += 1

#####   总结 此题与26 removeDuplicate 类似， 均需要双指针，记录位点， 区别在于此题需要判断当i ！= j 时，

