import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode target = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getNode(root, p, q);
        return this.target;
    }

    public boolean getNode(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        int letf = getNode(node.left, p, q)?1:0;
        int right = getNode(node.right,p,q)?1:0;
        int mid = (node == p|| node == q)?1:0;
        if((mid+ letf + right)>=2){
            target = node;
        }
        if((mid+letf+right)>0){
            return true;
        }else{
            return false;
        }
    }
}
// @lc code=end

