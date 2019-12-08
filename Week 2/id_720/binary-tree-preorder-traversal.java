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
            
            list.add(root.val);
            
            if (root.left != null) {
                getNode(root.left, list);
            }
            
            if (root.right != null) {
                getNode(root.right, list);
            }
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();

        getNode(root, list);
        
        return list;
    }
}
