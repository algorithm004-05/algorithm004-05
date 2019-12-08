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
    public $res = [];
    /**
     * 递归
     * 执行用时 :0 ms, 在所有 php 提交中击败了100%的用户
     * @param TreeNode $root
     * @return Integer[]
     */
    public function preorderTraversal($root)
    {
        if ($root) {
            array_push($this->res, $root->val);//根
            $this->preorderTraversal($root->left, $this->res);// 左
            $this->preorderTraversal($root->right, $this->res);// 右
        }
        return $this->res;
    }

    /**
     * 迭代 栈
     * 执行用时 :8 ms, 在所有 php 提交中击败了67.86%的用户
     * @param TreeNode $root
     * @return Integer[]
     */
    public function preorderTraversalStack($root)
    {
        $res = [];
        if ($root == null) {
            return $res;
        }
        $stack = new SplStack();
        $stack->push($root);
        while (!$stack->isEmpty()) {
            $root = $stack->pop();
            $res[] = $root->val;
            if ($root->right != null) {
                $stack->push($root->right);
            }
            if ($root->left != null) {
                $stack->push($root->left);
            }
        }
        return $res;
    }
}
