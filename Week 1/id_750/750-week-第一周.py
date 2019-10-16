# 1.删除排序数组中的重复项
from typing import List
import math


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 1
        j = 0
        for n in nums:
            if n != nums[i]:
                i += 1
            else:
                j += 1
        return len(nums) - j

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        for _ in range(k):
            nums.insert(0, nums.pop())

        print(nums)


if __name__ == '__main__':
    s = Solution()
    a = [1, 1, 2]
    # print(s.removeDuplicates(a))

    b = [1, 2, 3, 4, 5, 6, 7, 8]
    k = 25

    # print(s.rotate(b, k))

    print(b[::-1])
