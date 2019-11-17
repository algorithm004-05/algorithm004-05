from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        '''
        使用广度优先遍历
        :param root:
        :return:
        '''
        if not root: return []
        queue, result = [root], []
        while queue:
            result.append([node.val for node in queue])
            queue = [child for node in queue for child in node.children if child]
        return result


class Solution2:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        '''
        使用深度优先搜索
        :param root:
        :return:
        '''
        if not root: return []
        result = []

        def helper(root, index):
            if not root: return
            if len(result) < index + 1:
                result.append([])
            result[index].append(root.val)
            for child in root.children:
                helper(child, index + 1)

        helper(root, 0)
        return result
