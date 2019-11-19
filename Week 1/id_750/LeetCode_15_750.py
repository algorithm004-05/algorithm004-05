"""
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if not nums or n < 3:
            return []

        nums.sort()
        result_list = list()

        for i in range(len(nums) - 2):
            if nums[i] > 0:
                return result_list
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            L = i + 1
            R = n - 1
            while L < R:
                sum = nums[i] + nums[L] + nums[R]
                if sum < 0:
                    L += 1
                    while L < R and nums[L] == nums[L - 1]: L += 1
                elif sum > 0:
                    R -= 1
                    while L < R and nums[R] == nums[R + 1]: R += 1
                else:
                    result_list.append([nums[i], nums[L], nums[R]])
                    L += 1
                    R -= 1
                    while L < R and nums[L] == nums[L - 1]: L += 1
                    while L < R and nums[R] == nums[R + 1]: R += 1

        return result_list


if __name__ == '__main__':
    solution = Solution()

    nums = [-1, 0, 1, 2, -1, -4]
    for i, v in enumerate(nums[:-2]):
        print(i,v)

    # result = solution.threeSum(nums)
    # print(result)
