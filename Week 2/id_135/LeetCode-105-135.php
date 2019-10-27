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
     * @param Integer[] $preorder
     * @param Integer[] $inorder
     * @return TreeNode
     */
    function buildTree($preorder, $inorder) {
        $this->preorder = $preorder;
        $this->inorder = $inorder;
        $this->inmap = array_flip($inorder);
        return $this->helper(0,count($inorder)-1);

    }

    private $inmap; //反转中序数组中所有键以及它们关联的值
    private $preIndex = 0; // 前序参数索引
    private $preorder;
    private $inorder;

    function helper($instart,$inend){
        if($instart > $inend) return null;
        $node = $this->preorder[$this->preIndex];
        $inIndex = $this->inmap[$node];
        $node = new TreeNode($node);
        $this->preIndex++;

        $node->left = $this->helper($instart,$inIndex-1);
        $node->right = $this->helper($inIndex+1,$inend);
        return $node;
    }
}