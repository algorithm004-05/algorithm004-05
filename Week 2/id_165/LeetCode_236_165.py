# 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
#
# 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
#
# 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
#
#
#
#
#
# 示例 1:
#
# 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
# 输出: 3
# 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
#
#
# 示例 2:
#
# 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
# 输出: 5
# 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
#
#
#
#
# 说明:
#
#
# 所有节点的值都是唯一的。
# p、q 为不同节点且均存在于给定的二叉树中。
#
# Related Topics 树


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 遍历一遍二叉树，分别记下2个节点的路径p_path和q_path，时间复杂O(N),空间复杂O(logN) - 只需记父节点=树高
# 最后倒序遍历p_path和q_path，取出第一个相同的node

# class Solution(object):
#
#     def __init__(self):
#
#         self.p_path = []
#         self.q_path = []
#         self.path = []
#
#     def lowestCommonAncestor(self, root, p, q):
#         """
#         :type root: TreeNode
#         :type p: TreeNode
#         :type q: TreeNode
#         :rtype: TreeNode
#         """
#
#         self.visit(root, p, q)
#
#         if len(self.p_path) >= len(self.q_path):
#
#             shortest = self.q_path
#         else:
#             shortest = self.p_path
#
#         # 以p_path 和 q_path 中较短者shortest为基准开始遍历，
#         # 因为长的那个，长出来的部分一定不会在短的那个里面，所以直接从短的开始
#         for i in range(len(shortest) - 1, -1, -1):
#             # 倒序第一个遇到的相同的就是最近公共父节点
#             if self.p_path[i].val == self.q_path[i].val:
#                 return self.p_path[i]
#
#     def visit(self, node, p, q):
#
#         if node:
#
#             self.path.append(node)
#
#             if node.val == p.val:
#                 self.p_path = self.path[:]
#
#             elif node.val == q.val:
#                 self.q_path = self.path[:]
#
#             if node.left:
#                 self.visit(node.left, p, q)
#
#             if node.right:
#                 self.visit(node.right, p, q)
#
#             self.path.pop()

# leetcode submit region end(Prohibit modification and deletion)

# 空间复杂度O(1),时间复杂度O(N)， 可支持查找任意个数节点的最近公共父节点
class Solution2(object):

    def __init__(self):

        self.node = None

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        self.visit(root, p, q)
        return self.node

    def visit(self, node, p, q):

        if node:

            found = 0

            # 自己节点找到 +1， 这里不能return，因为子节点可能含有另一个数
            if node.val == p.val or node.val == q.val:
                found += 1

            # 节点左边找到+1
            if node.left:
                found += self.visit(node.left, p, q)

            # 节点右边找到+1
            if node.right:
                found += self.visit(node.right, p, q)

            # 因为只有2个数，上面的3个加1判断最多只能是2，
            # 如果等于2的话，说明当前节点就是最近公共的

            if found == 2 and not self.node:
                self.node = node

            return found
