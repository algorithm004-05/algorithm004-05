<?php
/**
 * 题目名称：binary-tree-preorder-traversal 二叉树的前序遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */


/**
 * 基于递归的前序遍历
 * @param TreeNode $root
 * @return Integer[]
 */
function preorderTraversal($root) {
    $res = [];
    traversal($root, $res);
    return $res;
}

function traversal($root, &$res) {
    if ($root == null) return;
    $res[] = $root->val;
    traversal($root->left, $res);
    traversal($root->right, $res); 
}