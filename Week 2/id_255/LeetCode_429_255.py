class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root==None:
            return []
        
        list_trans=[]
        queue=[root]        
        while queue:
            child=[]
            nodes=[]
            for node in queue:
                child.append(node.val)
                if node.children:
                    nodes+=node.children          
            list_trans.append(child)
            queue=nodes
        return list_trans