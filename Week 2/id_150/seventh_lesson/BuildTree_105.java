package com.geek.lee.leetcode.medium;

import com.geek.lee.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree_105 {
    private int[] preorder;
    private int[] inorder;
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 边界判断
        if (null == preorder || null == inorder || preorder.length != inorder.length) {
            return null;
        }
        this.inorder = inorder;
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i ++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        // 从前序数组中获取到root的值
        int rootVal = this.preorder[preIdx];
        // 构建root节点
        TreeNode node = new TreeNode(rootVal);
        /// 从中序遍历数组中获取node的位置, 小于nodeIndex的为左侧节点 大于nodeIndex为右侧节点
        int rootIdx = inorderMap.get(rootVal);
        preIdx ++;

        // 构建左子树
        node.left = buildTree(start, rootIdx - 1);
        // 构建右子树
        node.right = buildTree(rootIdx + 1, end);

        return node;
    }
}
