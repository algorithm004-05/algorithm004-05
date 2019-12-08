from typing import List


# 26.删除排序数组中的重复项
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums: return 0
        k = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[k] = nums[i]
                k += 1
        return k

    def removeDuplicates2(self, nums: List[int]) -> int:
        pass


if __name__ == '__main__':
    s = Solution()
    a = [1, 1, 2]
    print(s.removeDuplicates2(a))
