#
# @lc app=leetcode.cn id=515 lang=python3
#
# [515] 在每个树行中找最大值
#
# https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
#
# algorithms
# Medium (57.13%)
# Likes:    45
# Dislikes: 0
# Total Accepted:    4.4K
# Total Submissions: 7.9K
# Testcase Example:  '[1,3,2,5,3,null,9]'
#
# 您需要在二叉树的每一行中找到最大的值。
# 
# 示例：
# 
# 
# 输入: 
# 
# ⁠         1
# ⁠        / \
# ⁠       3   2
# ⁠      / \   \  
# ⁠     5   3   9 
# 
# 输出: [1, 3, 9]
# 
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# 
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        ret =[]
        if root == None:
            return ret
        leveList =[root]
        level = 0
        while leveList!=[]:
            curList = leveList
            leveList =[]
            maxVal = curList[0].val
            for i in curList:
                if maxVal < i.val:
                    maxVal = i.val
                if i.left != None:
                    leveList.append(i.left)
                if i.right !=None:
                    leveList.append(i.right)
            level +=1
            ret.append(maxVal)
        return ret
        
        
# @lc code=end

