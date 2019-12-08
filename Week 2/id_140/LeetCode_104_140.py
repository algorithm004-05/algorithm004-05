#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def maxDepth(self, root):
        maxlevel = 0
        if root is None :
            return 0
        else :
            left_height = self.maxDepth(root.left) 
            right_height = self.maxDepth(root.right) 
            return max(left_height, right_height) + 1
if __name__ == '__main__':
	s = Solution()
	tree = TreeNode([3,9,20,None,None,15,7])
	print(s.maxDepth(tree))