<?php
/**
 * 题目名称：binary-tree-postorder-traversal 二叉树的后序遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */


/**
 * @param TreeNode $root
 * @return Integer[]
 */
function postorderTraversal($root) {
    $res = [];
    $this->postorderRecr($root, $res);
    return $res;
}

function postorderRecr($node, &$res) {
    if ($node == null) return;
    $this->postorderRecr($node->left, $res);
    $this->postorderRecr($node->right, $res);
    $res[] = $node->val;
}