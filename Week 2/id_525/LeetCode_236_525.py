# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.result = None

        def helper(root):
            if not root: return False
            print(f'当前root，为：{root.val}')
            mid = root == p or q == root
            left = helper(root.left)
            right = helper(root.right)
            print(f'当前点为：{root.val} 左右子树为：{left} {right} ')
            if mid + left + right >= 2:
                self.result = root
            return mid or left or right

        helper(root)
        return self.result


class Solution2:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        '''
        使用父子指针进行判断，官方解法，比较巧妙。
        :param root:
        :param p:
        :param q:
        :return:
        '''
        parent = {root: None}
        stack = [root]
        while q not in parent or p not in parent:
            node = stack.pop()
            if node.left is not None:
                parent[node.left] = node
                stack.append(node.left)
            if node.right is not None:
                parent[node.right] = node
                stack.append(node.right)
        ancestors = set()
        while p:
            ancestors.add(p)
            p = parent.get(p)
        while q not in ancestors:
            q = parent.get(q)
        return q
