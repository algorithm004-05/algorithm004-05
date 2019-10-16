# 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
#
# 注意：答案中不可以包含重复的三元组。
#
# 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
#
# 满足要求的三元组集合为：
# [
#  [-1, 0, 1],
#  [-1, -1, 2]
# ]
#
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    # 第一遍
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        双指针
        """
        rdata = []
        nums.sort()
        for k in range(len(nums)-2):
            kn = nums[k]
            if kn > 0:
                break
            if k > 0 and nums[k] == nums[k - 1]: continue
            i = k + 1
            j = len(nums) - 1
            while i < j:
                sum_n = nums[i] + nums[j]
                if kn == -sum_n:
                    rdata.append([kn, nums[i], nums[j]])
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1
                elif sum_n < -kn:
                    i += 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                elif sum_n > -kn:
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1

        return rdata

    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s = Solution()
    nums = [-1, 0, 1, 2, -1, -4]
    print(nums)
    rlist = s.threeSum(nums)
    print(rlist)
