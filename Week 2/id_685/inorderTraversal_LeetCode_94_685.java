/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List lst = new ArrayList<Integer>();
        helper(lst,root);

        return lst;
    }
    public static void helper(List<Integer> list,TreeNode node) {
        if(node == null){
            return ;
        }
        helper(list,node.left);
        list.add(node.val);
        helper(list,node.right);
        //释放

    }
}
// @lc code=end

