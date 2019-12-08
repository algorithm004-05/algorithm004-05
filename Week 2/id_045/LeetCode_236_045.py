#@author:leacoder
#@des:  递归查找法 , 后序遍历 二叉树的最近公共祖先
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

'''
对于一个公共祖先（一定有子节点才能当祖先）来说，其两个子节点 p、q 有三种分布情况
1 p, q 分别位于 x 的左子树和右子树；
2 p, q 都在 x 的左子树（也包括祖先其自身，另一个字节点在左子树）；
3 p, q 都在 x 的右子树（也包括祖先其自身，另一个字节点在右子树）；

上述3条规律对每一子树都成立， 所以只要检查每个节点的 左右子树即可， 所以要用后续遍历
'''

class Solution: #所有的递归的返回值有4种可能性，None、p、q、公共祖先
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # 递归终止条件
        if root is None: #当遍历到叶结点后就会返回None
            return root
        if root == p or root == q : #当找到p或者q的是时候就会返回pq
            return root #如果公共祖先是自己（pq），并不需要寻找另外一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先
        
        leftNode = self.lowestCommonAncestor(root.left,p,q) #找root的左子树 找 p 或 q  返回的结点进行保存，可能是None 也可能是pq，还可能是公共祖先
        rightNode = self.lowestCommonAncestor(root.right,p,q) #找root的右子树 找 p 或 q  返回的结点进行保存，可能是None 也可能是pq，还可能是公共祖先
        
    
        if leftNode is not None and rightNode is not None:
            return root # p, q 分别位于 x 的左子树和右子树；
        elif rightNode is not None: #p, q 都在 x 的右子树（也包括祖先其自身，另一个字节点在右子树）； 
            return rightNode 
        elif leftNode is not None: # p, q 都在 x 的左子树（也包括祖先其自身，另一个字节点在左子树）；
            return leftNode 
        
    '''
     注意p,q必然存在树内, 且所有节点的值唯一!!!
        递归思想, 对以root为根的(子)树进行查找p和q, 如果root == None || p || q 直接返回root
        表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
        1. 左右子树的返回值都不为None, 由于值唯一左右子树的返回值就是p和q, 此时root为最近公共祖先
        2. 如果左右子树返回值只有一个不为None, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为最近公共祖先
        3. 左右子树返回值均为None, p和q均不在树中, 返回None
    '''
    
