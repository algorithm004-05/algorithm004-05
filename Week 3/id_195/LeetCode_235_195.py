class Solution:
    def lowestCommonAncestor(self, root, p, q):
        parent_val = root.val
        p_val = p.val
        q_val = q.val

        if q_val > parent_val and p_val > parent_val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif q_val < parent_val and p_val < parent_val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root
