#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#
# https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
#
# algorithms
# Medium (61.84%)
# Likes:    262
# Dislikes: 0
# Total Accepted:    28K
# Total Submissions: 45.1K
# Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
#
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
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# 前序遍历数组的特点是头结点在前引领后续节点，后续节点也均为头结点，缺点是无左右子树分界，直接写会将所有数据均写在左子树内
# 中序遍历的特点是根节点在数组中必分割左右树的元素，左右树数组中同样被其根节点分割；
# 因此，用前序遍历确定每层数的根节点，在中序列表中找到该节点，只需返回左右树元素个数，即可利用前序遍历树列表建立树

# 首先确定，递归函数返回值是什么？返回建立的新节点。
# 返回值如何与上层关联？ 上层节点的左右指针指向下层返回值
# 最下层递归终止条件是什么？当前层中节点数量为0，即in_left == in_right
# 终止条件发生后返回值是什么？返回值总是新建立的节点，但终止条件下，不新建立节点，故返回空节点。
# 终止条件判断的变量必与函数参数有关，参数改变使得终止条件成立。
# 参数与函数主体的处理不一定有关，若有关则可写独立递归。若无关则需要静态变量\全局变量辅助执行。
# 主题需要构建返回对象，改变递归参数。
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        nonlocal pre
        def helper(in_left = 0,in_right = len(inorder)):
            if in_left ==in_right:#2根据终止条件选定传递参数。
                return None #3确定终止条件下的返回类型
            
            Node = TreeNode(preorder[pre])#4函数主体-处理返回值

            index = idx_map[preorder[pre]]#6处理迭代参数的改变量
            pre_idx += 1 #返回值计算与参数无关的时，全局变量处理
            Node.left = helper(in_left,index) #5函数主体-处理返回值与层迭代的关系
            Node.right = helper(index+1，in_right)
            
            return Node #1确定返回类型
    pre = 0
    idx_map = {val:idx for idx, val in enumerate(inorder)}
    return helper()
# @lc code=end

