import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    //     //方法一，递归,但是题目建议使用迭代
    //     List<Integer> preResult = new ArrayList<>();
    //     preHelper(preResult, root);
    //     return preResult;
    // }
    // public void preHelper(List<Integer> preResult, TreeNode root) {
    //     if (root == null) return;
    //     preResult.add(root.val);
    //     preHelper(preResult, root.left);
    //     preHelper(preResult, root.right);
    // }

        // //方法二，迭代, 来自lLeetCode高票代码
        // List<Integer> result = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // while(root != null || !stack.empty()) {
        //     result.add(root.val);
        //     if (root.right != null) stack.push(root.right);
        //     root = root.left;
        //     if (root == null && !stack.isEmpty()) root = stack.pop();
        // }
        // return result;

        //方法三，非递归的LeetCode最高票代码，前中后序代码相对来说最好记，因为有规律
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                result.add(root.val);   //Add before going to children
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return result;
    }
}
// @lc code=end

