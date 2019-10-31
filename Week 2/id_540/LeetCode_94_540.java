package com.company;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_94_540 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // terminator
        if (null == root) {
            return new LinkedList<>();
        }

        List<Integer> results = new LinkedList<>();

        // drill down
        if (root.left != null) {
            results.addAll(inorderTraversal(root.left));
        }

        // process
        results.add(root.val);

        // drill down
        if (root.right != null) {
            results.addAll(inorderTraversal(root.right));
        }

        return results;
    }
}
