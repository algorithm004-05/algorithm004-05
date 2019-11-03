class Solution:

    # 两遍哈希表解法 O(n)
    def twoSum_1(self, nums, target):
        dict = {}
        for i,n in enumerate(nums):
            dict[n] = i

        for j in range(len(nums)):
            k = dict.get(target- nums[j])
            if k is not None and j!=k:
                return [j, k]

    # 一遍哈希表解法 O(n)
    def twoSum_2(self, nums, target):
        dict = {}
        for i,n in enumerate(nums):
            if dict.get(target - n) is not None:
                return [dict.get(target - n), i]
            dict[n] = i # 注意最后解决list中重复值的情况。

    # 暴力数组循环法 O(n)
    def twoSum_3(self, nums, target):
        for i in range(len(nums)):
            for j in range(1, len(nums)):
                if nums[i] == target - nums[j]:
                    return [i, j]

if __name__ == '__main__':
    testCase = [2, 7, 11, 15]
    target = 9
    solution = Solution()
    print("correct:", [0, 1], "\noutput:", solution.twoSum_3(testCase, target))