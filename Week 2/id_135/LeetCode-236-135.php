<?php
/**
 * Definition for a binary tree node.
 * function TreeNode($val) {
 *     $this->>val = $val;
 *     $this->>left = $this->right = null;
 * }
 */

class Solution{
    public function lowestCommonAncestor($root, $p, $q)
    {
        if (!$root || $root === $p || $root === $q) return $root;

        $left = lowestCommonAncestor($root->left, $p, $q);
        $right = lowestCommonAncestor($root->right, $p, $q);
        return ($left && $right) ? $root : ($left || $right);
    }
}