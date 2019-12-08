#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#
# https://leetcode-cn.com/problems/validate-binary-search-tree/description/
#
# algorithms
# Medium (27.70%)
# Likes:    312
# Dislikes: 0
# Total Accepted:    46K
# Total Submissions: 165.9K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
# 
# 假设一个二叉搜索树具有如下特征：
# 
# 
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
# 
# 
# 示例 1:
# 
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 输出: true
# 
# 
# 示例 2:
# 
# 输入:
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
# 根节点的值为 5 ，但是其右子节点值为 4 。
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
# 中序遍历，验证排序
# 递归 右子树带下界，左子树带上界，
# 返回值：是否，参数：根节点，上界，下界
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:

        return self.isok(root)

    def isok(self,node,lower=float('-inf'),upper=float('inf')):
        if not node:
            return True
        val = node.val
        if val<=lower or val >= upper:
            return False
        if not self.isok(node.left,lower,node.val):
            return False
        if not self.isok(node.right,node.val,upper):
            return False
        return True

class TreeNode:
    def __init__(self,x):
        self.val =x
        self.left =None
        self.right =None
        
# @lc code=end

