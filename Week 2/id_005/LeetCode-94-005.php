<?php
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution
{
    /**
     * 迭代
     * 执行用时 :8 ms, 在所有 php 提交中击败了62.50%的用户
     * @param TreeNode $root
     * @return Integer[]
     */
    public function inorderTraversal($root)
    {
        $res = [];
        $list = [];
        while (!empty($list) ||  $root != null) {
            while ($root != null) {
                array_unshift($list, $root);// 先丢根节点
                $root = $root->left;// 然后把左边的节点丢进栈中
            }
            $root = array_shift($list);
            array_push($res, $root->val);// 取出节点
            $root = $root->right;// 再访问右节点
        }
        return $res;
    }

    /**
     * 递归
     * 执行用时 :0 ms, 在所有 php 提交中击败了100%的用户
     * @param TreeNode $root
     * @return Integer[]
     */
    public $res = [];
    public function inorderTraversalRecursion($root)
    {
        if ($root) {
            $this->inorderTraversalRecursion($root->left);// 左
            array_push($this->res, $root->val);// 根
            $this->inorderTraversalRecursion($root->right);// 右
        }
        return $this->res;
    }
}
