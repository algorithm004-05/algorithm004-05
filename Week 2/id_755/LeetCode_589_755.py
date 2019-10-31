"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res_lst = []
        def pre_traversal(possible_nodes):
            if type(possible_nodes) is list:
                for node in possible_nodes:
                    res_lst.append(node.val)
                    pre_traversal(node.children)
            if type(possible_nodes) is Node:
                res_lst.append(possible_nodes.val)
                pre_traversal(possible_nodes.children)
            return
        pre_traversal(root)
        return res_lst