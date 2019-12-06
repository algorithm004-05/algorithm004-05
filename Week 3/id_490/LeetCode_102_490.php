<?php
/**
 * 题目名称：binary-tree-level-order-traversal 二叉树的层次遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * 第一种解法：迭代法
     * @param TreeNode $root
     * @return Integer[][]
     */
    function levelOrder($root) {
        if (empty($root)) {
            return [];
        }
        $res = [];
        $queue = [$root];
        while (!empty($queue)) {
            $cur = [];
            $len = count($queue);
            for ($i=0; $i<$len; $i++) {
                $node = array_shift($queue);
                array_push($cur, $node->val);
                $node->left && array_push($queue, $node->left);
                $node->right && array_push($queue, $node->right);
            }
            $res[] = $cur;
        }
        
        return $res;
    }
}
