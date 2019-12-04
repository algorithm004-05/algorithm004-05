class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        list_trans=[]
        if root==None:
            return []
        else:
            for child in root.children:
                list_trans+=self.postorder(child)
                # list_trans.append(child.val)
            list_trans.append(root.val)
        return list_trans
    
        # res = []
        # if root == None:
        #     return res

        # def recursion(root, res):
        #     for child in root.children:
        #         recursion(child, res)
        #     res.append(root.val)

        # recursion(root, res)
        # return res   