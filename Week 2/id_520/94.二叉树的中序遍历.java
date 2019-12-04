import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

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
    //     //方法一，递归
    //     List<Integer> result = new ArrayList<>();
    //     inHelper(root, result);
    //     return result;
    // }
    // public void inHelper(TreeNode root, List<Integer> result) {
    //     if (root == null) return;
    //     inHelper(root.left, result);
    //     result.add(root.val);
    //     inHelper(root.right, result);
    // }
        
        //方法二，非递归的LeetCode最高票代码，前中后序代码相对来说最好记，因为有规律
            LinkedList<Integer> result = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.empty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode node = stack.pop();
                    result.add(node.val); //Add after all left children
                    root = node.right;
                }
        }
        return result;
    }
}
// @lc code=end

