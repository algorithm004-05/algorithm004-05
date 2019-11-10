#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 深度有限遍历
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # 存放最终结果的数组levels
        levels = []
        # root不存在，则时空树，返回levels即[]
        if not root:
            return levels
        # 递归函数
        def dfs(node, level):
            # 数组长度=数组最大下标（从0开始）+1，
            # 如果两者相等，证明levels没有第level层
            if len(levels) == level:
                levels.append([])
            # 在第level个子数组中添加node.val
            levels[level].append(node.val)
            # 如果有做节点，从做节点继续遍历，达到结束条件进入右节点判断
            if node.left:
                dfs(node.left,level+1)
            if node.right:
                dfs(node.right,level+1)
        dfs(root,0)
        return levels

    # 广度有限遍历
    def levelOrder2(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        queue = [root]                       
        resutlt = []
        while queue:
            child = []                       # 该轮循环的结果集
            node = []                        # 存放while下一次的 数据集
            for item in queue:  
                child.append(item.val)
                # 判断当前的数据有没有子节点,有就加到node里       
                if item.left:
                    node.append(item.left)   
                if item.right:
                    node.append(item.right)
            # 把while这次的结果集放到输出数组里
            resutlt.append(child)                
            queue = node                     # 这是把 node里 搜集的该次循环节点的子节点 放到 queue里
        return resutlt