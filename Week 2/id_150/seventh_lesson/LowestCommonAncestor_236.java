package com.geek.lee.leetcode.medium;

import com.geek.lee.leetcode.tree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor_236 {

    // 定义返回结果
    private TreeNode res = null;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (null == root) {
            return res;
        }

        /**
         * 解法1. 递归
         * 深度遍历tree, 找到p点和q点, 并记录p点的祖先.和q点的祖先.
         *
         */
        recursionTree(root, p, q);
        return res;
    }

    /**
     * 递归解法实现
     * @param curNode
     * @param p
     * @param q
     * @return
     */
    private boolean recursionTree(TreeNode curNode, TreeNode p, TreeNode q) {
        if (null == curNode) {
            return false;
        }

        // 判断祖先的左侧状态
        int leftStat = recursionTree(curNode.left, p, q) ? 1 : 0;
        // 判断祖先节点右侧状态
        int rightStat = recursionTree(curNode.right, p, q) ? 1 : 0;

        int isCur = (curNode == p || curNode == q) ? 1 : 0;

        if (leftStat + rightStat + isCur >= 2) {
            res = curNode;
        }

        return leftStat + rightStat + isCur > 0;
    }
}
