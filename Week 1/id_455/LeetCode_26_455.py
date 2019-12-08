#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        pre,cur = 0,1
        while cur < len(nums):
            if nums[cur] == nums[pre]:
                nums.pop(cur)
            else:
                pre,cur = pre+1,cur+1
        return len(nums)

# @lc code=end

