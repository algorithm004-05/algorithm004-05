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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        recursion(root, list);
        return list;
    }
    void recursion(TreeNode node, List<Integer> list) {
        //终结条件
        if (node == null) {
            return;
        }
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
    }
}
