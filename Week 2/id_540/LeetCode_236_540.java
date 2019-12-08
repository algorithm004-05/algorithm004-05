package com.company;

import java.util.Stack;

public class LeetCode_236_540 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> parentStackP = new Stack<>();
    private Stack<TreeNode> parentStackQ = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // dfs and build stacks
        dfs(root, p, q);

        // remove unnecessary stack levels
        if (parentStackP.size() > parentStackQ.size()) {
            // make p the size of q
            reduceStackSize(parentStackP, parentStackP.size() - parentStackQ.size());
        } else if (parentStackP.size() < parentStackQ.size()) {
            // make q the size of p
            reduceStackSize(parentStackQ, parentStackQ.size() - parentStackP.size());
        }

        // compare stacks
        int stackHeight = parentStackP.size();
        for (int i = 0; i < stackHeight; i++) {
            TreeNode nodeP = parentStackP.pop();
            TreeNode nodeQ = parentStackQ.pop();
            if (nodeP.val == nodeQ.val) {
                return nodeP;
            }
        }

        root.val = root.val + 1;
        return root;
    }

    private void reduceStackSize(Stack<TreeNode> stack, int sizeToReduce) {
        for (int i = 0; i < sizeToReduce; i++) {
            stack.pop();
        }
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 1. terminator
        if (!parentStackP.isEmpty() && null != parentStackP.peek() && parentStackP.peek().val == p.val
                && !parentStackQ.isEmpty() && null != parentStackQ.peek() && parentStackQ.peek().val == q.val) {
            return;
        }

        // 2. process
        if (parentStackP.isEmpty() ||
                (!parentStackP.isEmpty() && null != parentStackP.peek() && parentStackP.peek().val != p.val)) {
            parentStackP.push(root);
        }

        if (parentStackQ.isEmpty() ||
                (!parentStackQ.isEmpty() && null != parentStackQ.peek() && parentStackQ.peek().val != q.val)) {
            parentStackQ.push(root);
        }

        // 3. drill down
        if (null != root.left) {
            dfs(root.left, p, q);
        }

        if (null != root.right) {
            dfs(root.right, p, q);
        }

        // 4. reverser states
        if (!parentStackP.isEmpty() && null != parentStackP.peek() && parentStackP.peek().val != p.val) {
            parentStackP.pop();
        }

        if (!parentStackQ.isEmpty() && null != parentStackQ.peek() && parentStackQ.peek().val != q.val) {
            parentStackQ.pop();
        }
        return;
    }
}
