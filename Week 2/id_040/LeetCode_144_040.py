#给定一个二叉树，返回它的 前序 遍历。
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
#输出: [1,2,3]
#
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# Related Topics 栈 树



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> list:
        rdata = []
        if root:
            rdata.append(root.val)
            rdata.extend(self.preorderTraversal(root.left))
            rdata.extend(self.preorderTraversal(root.right))

        return rdata

#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    root = TreeNode(1)
    t2 = TreeNode(2)
    t3 = TreeNode(3)

    root.right = t2
    t2.left = t3

    s = Solution()
    print(s.preorderTraversal(root))