class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        trans_list=[]
        if root==None:
            return []
        else:
            trans_list.append(root.val)
            trans_list+=self.preorderTraversal(root.left)
            trans_list+=self.preorderTraversal(root.right)
        return trans_list