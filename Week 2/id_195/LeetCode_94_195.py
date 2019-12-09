class Solution:

    # 递归调用 O(n), 注意这里使用了闭包调用递归函数
    def inorderTraversal_1(self, root):
        treeVal = []
        def helper(self, res, root):
            if root:
                helper(root.left)
                treeVal.append(root.val)
                helper(root.right)
        helper(root)
        return treeVal

    # 用栈进行维护，将依次访问节点左子树，同时压入栈中，当访问到最左节点时，出栈，记录节点值，然后访问出栈节点的右子树，再按照之前访问右节点的左子树 O(n)
    def inorderTraversal_2(self, root):
        treeVal = []
        stack = []
        p = root
        while p or stack:
            while p:
                stack.append(p)
                p = p.left
            p = stack.pop()
            treeVal.append(p.val)
            p = p.right
        return treeVal

    # 颜色标记法，对节点进行颜色标记，未访问过的节点标记为白（0），访问过标记为黑（1）, 测试时发现超时
    def inorderTraversal_3(self, root):
        treeVal = []
        stack = [(0, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == 0:
                stack.append((0, node.left))
                stack.append((1, node))
                stack.append((0, node))
            else:
                treeVal.append(node.val)
        return treeVal
if __name__ == '__main__':
    testCase = [1, 2, 3]
