# 根据一棵树的前序遍历与中序遍历构造二叉树。
#
# 注意:
# 你可以假设树中没有重复的元素。
#
# 例如，给出
#
# 前序遍历 preorder = [3,9,20,15,7]
# 中序遍历 inorder = [9,3,15,20,7]
#
# 返回如下的二叉树：
#
#     3
#   / \
#  9  20
#    /  \
#   15   7
# Related Topics 树 深度优先搜索 数组


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def buildTreeNode(self, preorder, inorder):
        if not preorder:
            return None

        root = preorder[0]

        node = TreeNode(root)

        partition = inorder.index(root)

        node.left = self.buildTreeNode(preorder[1:partition + 1], inorder[0:partition])

        node.right = self.buildTreeNode(preorder[partition + 1:], inorder[partition + 1:])

        return node

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        return self.buildTreeNode(preorder, inorder)



# leetcode submit region end(Prohibit modification and deletion)
