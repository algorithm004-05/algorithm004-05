# BFS
# 法一
class Solution:
    def levelOrder(self,root):
        """利⽤队列实现树的层次遍历"""
        if root == None:
            return
        res = []
        queue = []
        queue.append(root)
        while queue:
            node = queue.pop(0)
            res.append(node.val)
            if node.left is not None:
                queue.append(node.left)
            if node.right != None:
                queue.append(node.right)
        return res

# 法二
class Solution:
    def levelOrder(self, root):
        """利用数组进行层次遍历"""
        if not root:
            return []
        res = []
        cur_level = [root]
        while cur_level:
            next_level = []
            for i in cur_level:
                res.append(i.val)
                if i.left:
                    next_level.append(i.left)
                if i.right:
                    next_level.append(i.right)
            cur_level = next_level
        return res

# LeetCode102
# 第一遍：
# 法一（1）：迭代法（数组）
# 思想：当前节点cur_level，循环遍历当前节点的子节点，放入next_level，对每一次遍历所有节点：把他的左右节点放入next_level，遍历结束后更新cur_level
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """迭代法：数组实现二叉树层次遍历"""
        if not root:
            return []
        res = []
        cur_level = [root]
        while cur_level:
            temp = []
            next_level = []
            for node in cur_level:      # 标志层结束的方法：一层一层地遍历
                temp.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            res.append(temp)
            cur_level = next_level
        return res

# 法一（2）：迭代法（队列）
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """队列实现二叉树层次遍历"""
        if not root:
            return []
        res = []
        queue = [root]
        while queue:
            temp = []
            for i in range(len(queue)):    # 关键在于利用queue的长度标志层的结束
                node = queue.pop(0)
                temp.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(temp)
        return res