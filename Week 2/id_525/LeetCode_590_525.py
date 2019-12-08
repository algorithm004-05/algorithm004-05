from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        '''
        使用深度优先遍历
        :param root:
        :return:
        '''
        result = []

        def helper(root):
            if not root:
                return
            for node in root.children:
                helper(node)
            result.append(root.val)

        helper(root)
        return result


class Solution2:
    def postorder(self, root: 'Node') -> List[int]:
        '''
        使用栈模拟
        :param root:
        :return:
        '''
        if not root: return []
        stack = []
        result = [root.val]
        stack.extend(root.children)
        while stack:
            node = stack.pop()
            if node is not None:
                stack.extend(node.children)
                result.append(node.val)
        result.reverse()
        return result
