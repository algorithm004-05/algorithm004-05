class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        list_len = len(nums)

        for i in range(list_len - 1):
            first_num = nums[i]
            expect_num = target - first_num

            if expect_num < 0:
                continue
            else:
                if expect_num in nums:
                    for y in range(i + 1, list_len - 1):
                        if nums[y] == expect_num:
                            return([i, y])
                        else:
                            continue