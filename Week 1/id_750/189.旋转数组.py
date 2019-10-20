from typing import List


# 189.旋转数组
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        # 利用了python切片的特性
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]


if __name__ == '__main__':
    s = Solution()
    b = [1, 2, 3, 4, 5, 6, 7, 8]
    k = 3

    s.rotate(b, k)
