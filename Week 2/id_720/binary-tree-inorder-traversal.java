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
    
    public void getNode(TreeNode root, List<Integer> list) {
        
        if (root != null) {
            
            if (root.left != null) {
                getNode(root.left, list);
            }
            
            list.add(root.val);
            
            if (root.right != null) {
                getNode(root.right, list);
            }
        }
    }
        
        
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();

        getNode(root, list);
        
        return list;
    }
}
