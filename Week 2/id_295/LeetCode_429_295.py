# 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
#
# 例如，给定一个 3叉树 :
#
#  
#
#
#
#  
#
# 返回其层序遍历:
#
# [
#      [1],
#      [3,2,4],
#      [5,6]
# ]
#  
#
# 说明:
#
# 树的深度不会超过 1000。
# 树的节点总数不会超过 5000。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""

# 使用队列保存每层结点，每次遍历将每层结点加入到 output
from typing import List


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        output, queue = [], [root] if root else []
        while queue:
            output.append([node.val for node in queue])
            queue = [child for node in queue for child in node.children]
        return output
