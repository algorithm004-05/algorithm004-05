"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res_lst = []
        def post_traversal(possible_nodes):
            if type(possible_nodes) is Node:
                post_traversal(possible_nodes.children)
                res_lst.append(possible_nodes.val)
            if type(possible_nodes) is list:
                for node in possible_nodes:
                    post_traversal(node.children)
                    res_lst.append(node.val)
            return
        post_traversal(root)
        return res_lst