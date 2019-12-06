class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        trans_list=[]
        if root==None:
            return []
        else:
            trans_list+=self.inorderTraversal(root.left)
            trans_list.append(root.val)   
            trans_list+=self.inorderTraversal(root.right)
        return trans_list