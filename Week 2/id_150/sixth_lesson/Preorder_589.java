package com.geek.lee.leetcode.easy;

import com.geek.lee.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */

/**
 * 589. N叉树的前序遍历
 */
public class Preorder_589 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preorder(root, result);
        return result;
    }

    /**
     * N叉树的前序遍历
     * 同二叉树前序遍历
     * 遍历顺序:
     *  1. 根
     *  2. 左子树
     *  3. 右子树
     * @param root
     * @param result
     */
    private void preorder(Node root, List<Integer> result) {
        // 递归终止条件
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (null != root.children && root.children.size() > 0) {
            for (Node node : root.children) {
                preorder(node, result);
            }
        }
    }
}
