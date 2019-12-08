# @author:leacoder
# @des: 递归 从前序与中序遍历序列构造二叉树


'''
前序遍历： 根结点 ---> 左子树 ---> 右子树
中序遍历： 左子树---> 根结点 ---> 右子树
后序遍历： 左子树 ---> 右子树 ---> 根结点

构建二叉树其实就是重复处理
1、找到各个子树的根节点 root
2、构建该根节点的左子树
3、构建该根节点的右子树

例题中：

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
根据遍历特点可知：

preorder 的第一个元素 3 是整棵树的根节点。
inorder 中 3 的左侧 [9] 是树的左子树，右侧 [15, 20, 7] 构成了树的右子树。
3的位置+1为根节点左子树节点个数，可以通过 preorder 找到根节点 左右子树具体有哪些节点

'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        if len(inorder) == 0:
            return None
        # 找根节点
        root = TreeNode(preorder[0])
        # 找 root 在 inorder的位置，来构建根节点的左右子树
        index = inorder.index(preorder[0])
        # 左子树
        root.left = self.buildTree(preorder[1:index+1], inorder[:index])
        # 右子树
        root.right = self.buildTree(preorder[index+1:], inorder[index+1:])

        return root