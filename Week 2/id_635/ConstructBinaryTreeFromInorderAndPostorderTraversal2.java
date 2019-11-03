package com.simon.leetcode.lcn106;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length, postorder.length);
    }

    public static TreeNode build(int[] inorder, int[] postorder, int inStart, int postEnd, int length) {
        if (length == 0)
            return null;

        int root = postorder[postEnd - 1];
        TreeNode treeNode = new TreeNode(root);
        if (length == 1)
            return treeNode;

        for (int i = length - 1; i >= 0; i--) {
            if (root == inorder[inStart + i]) {
                treeNode.left = build(inorder, postorder, inStart, postEnd - length + i, i);
                treeNode.right = build(inorder, postorder, inStart + i + 1, postEnd - 1, length - 1 - i);
                return treeNode;
            }
        }

        return null;
    }
}
