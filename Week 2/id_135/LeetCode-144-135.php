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
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $res = [];
        $this->helper($root,$res);
        return $res;
    }

    function helper($root,&$res){
        if($root == null) return;
        $res[] = $root->val;
        $this->helper($root->left,$res);
        $this->helper($root->right,$res);
    }
}