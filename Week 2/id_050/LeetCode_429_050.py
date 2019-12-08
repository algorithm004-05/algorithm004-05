"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        q, ret = [root], []
        while q:
            level_tmp = []
            for node in q:
                level_tmp.append(node.val)
            ret.append(level_tmp)
            
            new_q = []
            for node in q:
                for child in node.children:
                    if child:
                        new_q.append(child)
            q = new_q
        return ret

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
# update 
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        q, ret = [root], []
        while q:
            ret.append([node.val for node in q])
            q = [child for node in q for child in node.children if child]
        return ret
        
