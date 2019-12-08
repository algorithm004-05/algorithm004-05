#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#
# https://leetcode-cn.com/problems/jump-game/description/
#
# algorithms
# Medium (36.46%)
# Likes:    352
# Dislikes: 0
# Total Accepted:    39.9K
# Total Submissions: 109K
# Testcase Example:  '[2,3,1,1,4]'
#
# 给定一个非负整数数组，你最初位于数组的第一个位置。
# 
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
# 
# 判断你是否能够到达最后一个位置。
# 
# 示例 1:
# 
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
# 
# 
# 示例 2:
# 
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
# 
# 
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        """
        思路：
        从数组倒数第二个数开始，判断这个数加上自己的下标是否大于等于他的下一个下标位置
        如果为真，说明该位置能通过大于等于1步走下下一个位置，这个时候就要继续循环判断
        他的上一个位置能否这样走到他这里。
        如果为假，就要看继续判断他的上一个位置能否走到他的下一个位置
        """
        
        canJumpLocation = len(nums) - 1
        i = canJumpLocation - 1
        while True:
            if i < 0:
                break
            if nums[i] + i >= canJumpLocation:
                canJumpLocation = i
            i -= 1
        return canJumpLocation == 0
                
            
# @lc code=end

