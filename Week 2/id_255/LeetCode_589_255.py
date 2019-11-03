class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        list_trans=[]
        if root==None:
            return []
        else:
            list_trans.append(root.val)
            for child in root.children:
                list_trans+=self.preorder(child)
        return list_trans  