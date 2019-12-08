## 删除排序数组中的重复项
# 方法： 快慢指针  时间：O(n)  空间：O(1)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        s = 0
        for f in range(0, len(nums)):
            if nums[f] != nums[s]:
                s += 1
                nums[s] = nums[f]
                
        return s + 1