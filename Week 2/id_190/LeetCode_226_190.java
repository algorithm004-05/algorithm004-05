/**
 * 翻转二叉树
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        //分别番转左右子树
        TreeNode leftChild = invertTree(root.left);
        TreeNode rightChild = invertTree(root.right);
        
        //翻转根节点
        root.left = rightChild;
        root.right = leftChild;
        
        return root;
        
        
        
    }
}