<?php
/**
 * 题目名称：binary-tree-inorder-traversal 二叉树的中序遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */


/**
 * 基于递归的中序遍历
 * @param TreeNode $root
 * @return Integer[]
 */
function inorderTraversal($root) {
    $res = [];
    traversal($root, $res);
    return $res;
}

function traversal($root, &$res) {
    if ($root == null) return;
    if ($root->left != null) {
        traversal($root->left, $res);
    }
    $res[] = $root->val;
    if ($root->right != null) {
        traversal($root->right, $res);
    }
}