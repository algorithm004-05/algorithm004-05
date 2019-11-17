"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res_lst = []
        queue = collections.deque()
        queue.append((root, 1))
        while queue:
            possible_nodes, level = queue.popleft()
            # update res_lst based on type of popped node
            if type(possible_nodes) is Node:
                if level == len(res_lst):
                    res_lst[level - 1].append(possible_nodes.val)
                else:
                    res_lst.append([possible_nodes.val])
                if possible_nodes.children:
                    queue.append((possible_nodes.children, level + 1))
            elif type(possible_nodes) is list:
                for node in possible_nodes:
                    if level == len(res_lst):
                        res_lst[level - 1].append(node.val)
                    else:
                        res_lst.append([node.val])
                    if node.children:
                        queue.append((node.children, level + 1))
        return res_lst