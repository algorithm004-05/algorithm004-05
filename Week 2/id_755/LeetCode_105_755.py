# first try
"""def construct(index_pre, index_in):
            if index_in == ... :
                return None
            if index_pre == len(preorder):
                return
            value = preorder[index_pre]
            node = Node(value)
            node.left = construct(index_pre+1, inorder.index(value))
            node.right = construct(index_pre+2, inorder.index(value))
            return node"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        index_pre = {"index": 0}

        def construct(index_left, index_right):
            if index_left == index_right:
                return None
            value = preorder[index_pre["index"]]
            node = TreeNode(value)

            index_pre["index"] += 1
            node.left = construct(index_left, inorder.index(value))
            node.right = construct(inorder.index(value) + 1, index_right)
            return node

        return construct(0, len(inorder))
