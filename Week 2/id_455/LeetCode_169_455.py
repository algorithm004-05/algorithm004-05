#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        def majority_element_rec(lo, hi):
            if lo == hi:
                return nums[lo]

            mid = lo + (hi - lo) // 2
            left = majority_element_rec(lo, mid)
            right = majority_element_rec(mid + 1, hi)

            if left == right:
                return left
            
            left_cnt = sum(1 for i in range(lo, hi + 1) if nums[i] == left)
            right_cnt = sum(1 for i in range(lo, hi + 1) if nums[i] == right)

            return left if left_cnt > right_cnt else right


        return majority_element_rec(0, len(nums) - 1)



        
# @lc code=end

