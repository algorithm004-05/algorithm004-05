# 移动零问题
# 思路：抽象问题具体化，类比现实中高矮站队问题：把所有矮的（比如低于1.5米记为0）放在队的后面
#       a.一个指针遍历寻找高的（外层循环）
#       b.另一个指针记录矮的位置
#       矮和首次i碰到高的要交换位置，j+=1继续找矮的
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i] 
                i +=1
                j += 1