/**
 *98. 验证二叉搜索树
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
        }
    
    public boolean isValid(TreeNode root,Integer min,Integer max) {
        if(root==null)return true;
        if(min!=null&&root.val<=min)return false;
        if(max!=null&&root.val>=max)return false;
        
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
        
    }
}