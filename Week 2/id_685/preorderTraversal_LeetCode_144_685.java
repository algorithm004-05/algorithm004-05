import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preHelper(lst,root);
        return lst;
    }
    public static void preHelper(List<Integer> list,TreeNode node) {
            if(node == null) {
                return ;
            }
            list.add(node.val);
            preHelper(list,node.left);
            preHelper(list,node.right);
    }
}
// @lc code=end

