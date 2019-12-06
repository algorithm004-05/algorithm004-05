# @author:leacoder
# @des:  双指针  移动零

'''
i：用于遍历 整个数组
j: 指向非0数位置
遍历数组，将非0数填入j所在位置j后移，将 j位置到最后补0
'''
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        length = len(nums)
        j = 0
        for i in range(0,length):   # 遍历数组
            if 0!=nums[i]:
                nums[j],j = nums[i],j + 1   # 将非0数填入j所在位置j后移
        for p in range(j,length):   # 将 j位置到最后补0
            nums[p] = 0