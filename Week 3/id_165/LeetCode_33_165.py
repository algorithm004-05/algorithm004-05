# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
#
# 你可以假设数组中不存在重复的元素。
#
# 你的算法时间复杂度必须是 O(log n) 级别。
#
# 示例 1:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
#
#
# 示例 2:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# Related Topics 数组 二分查找


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def find_min(self, nums):

        left, right = 0, len(nums) - 1

        while left < right:

            mid = left + (right - left) // 2

            if nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1

        return left

    def find_target(self, nums, target, left, right):

        while left <= right:

            mid = left + (right - left) // 2

            if nums[mid] == target:
                return mid

            if target < nums[mid]:
                right = mid - 1

            else:
                left = mid + 1

        return -1

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        min_idx = self.find_min(nums)
        print(min_idx)

        if not nums:
            return -1

        if target == nums[min_idx]:
            return min_idx

        if target < nums[0] or min_idx == 0:

            return self.find_target(nums, target, min_idx, len(nums) - 1)

        else:

            return self.find_target(nums, target, 0, min_idx)


print(Solution().find_min([8,9,2,3,4,5,6]))


# leetcode submit region end(Prohibit modification and deletion)
