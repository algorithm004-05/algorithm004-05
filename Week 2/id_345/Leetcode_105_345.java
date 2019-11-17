package xyz.isok.algorithm.leetcode.easy;

import xyz.isok.algorithm.tree.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 */
public class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int rootIdx = 0;
    private int[] preorder, inorder;
    private Map<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (int i : inorder) {
            idxMap.put(i, idx);
            idx++;
        }
        return buildSubTree(0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int start, int end) {
        if (start > end) return null;
        int rootValue = preorder[rootIdx];
        TreeNode root = new TreeNode(rootValue);
        int boundary = idxMap.get(rootValue);
        rootIdx++;
        root.left = buildSubTree(start, boundary - 1);
        root.right = buildSubTree(boundary + 1, end);
        return root;
    }
}
