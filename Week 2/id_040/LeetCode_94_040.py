#给定一个二叉树，返回它的中序 遍历。
#
# 示例:
#
# 输入: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
#输出: [1,3,2]
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# Related Topics 栈 树 哈希表



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> list:
        # 中序遍历 递归顺序 左-根-右
        rdata = []
        if root:
            rdata.extend(self.inorderTraversal(root.left))
            rdata.append(root.val)
            rdata.extend(self.inorderTraversal(root.right))

        return rdata

#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    root = TreeNode(1)
    t2 = TreeNode(2)
    t3 = TreeNode(3)

    root.right = t2
    t2.left = t3

    s = Solution()
    print(s.inorderTraversal(root))
