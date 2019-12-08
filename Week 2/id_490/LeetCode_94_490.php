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

function traversal($node, &$res) {
    if ($node == null) return;
    traversal($node->left, $res);
    $res[] = $node->val;
    traversal($node->right, $res);
}