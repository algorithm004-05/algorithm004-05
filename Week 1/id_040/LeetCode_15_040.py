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
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        暴力求解
        """
        rlist = []
        for l in nums:
            for n in nums:
                for m in nums:
                    if n + m + l == 0:
                        rlist.append([l, n, m])
        return rlist

    def twoSum(self, nums, target):
        target = -target
        h = {}
        for n in nums:
            if h.get(n):
                return n, h.get(n), True
            h[target - n] = n
        return 0, 0, False

    # leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    s = Solution()
    nums = [0, 0, 0]
    print(nums)
    rlist = s.threeSum(nums)
    print(rlist)
