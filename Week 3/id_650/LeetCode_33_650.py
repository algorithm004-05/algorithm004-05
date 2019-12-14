#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
#
# algorithms
# Medium (36.07%)
# Likes:    396
# Dislikes: 0
# Total Accepted:    51.5K
# Total Submissions: 142.7K
# Testcase Example:  '[4,5,6,7,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# 
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
# 
# 你可以假设数组中不存在重复的元素。
# 
# 你的算法时间复杂度必须是 O(log n) 级别。
# 
# 示例 1:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
# 
# 
# 示例 2:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# 
#

# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        # 先找到无序的地方，利用二分查找法，只不过每次对比的值是最右侧的值或者最左侧的值
        """
            left, right = 0, len(nums) - 1
            if nums[left] < nums[right]:
                return 0
                            
            while left <= right:
                mid = (left + right) // 2
                
                if nums[mid] > nums[mid+1]:
                    return mid+1
                elif nums[mid] > nums[left]:
                    left = mid + 1
                else:
                    right = mid - 1

            return -1
        """
        
        def search_rotated(nums):
            
            left, right = 0, len(nums) - 1
            while right - left >= 2:
                mid = (left + right) // 2
                
                if nums[mid-1] > nums[mid] and nums[mid] < nums[mid+1]:
                    return mid
                elif nums[mid] > nums[left]:
                    left = mid
                else:
                    right = mid - 1

            if right - left == 0:
                return -1
            if right - left == 1:
                if nums[left] > nums[right]:
                    return right
                return -1

        def binary_search(nums, target) -> int:
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return (mid + index) % len(nums)
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return -1
        index = search_rotated(nums)
        if index == -1:
            index = 0
            return binary_search(nums, target)
        sorted_nums = nums[index:] + nums[:index]
        return binary_search(sorted_nums, target)

# @lc code=end

