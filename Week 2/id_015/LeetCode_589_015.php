<?php
/*
// Definition for a Node.
class Node {
    public $val;
    public $children;

    @param Integer $val
    @param list<Node> $children
    function __construct($val, $children) {
        $this->val = $val;
        $this->children = $children;
    }
}
*/
class Solution {
    /**
     * @param Node $root
     * @return Integer[]
     */
    function preorder($root) {
        $trans = [];
        if (empty($root)) {
            return $trans;
        }
        $this->preOrderTrans($root, $trans);
        return $trans;
    }

    /**
     * @param Node $root
     * @param $trans
     */
    function preOrderTrans($root, &$trans) {
        $trans[] = $root->val;
        if ($root->children != null) {
            for ($i = 0; $i < count($root->children); $i++) {
                $this->preOrderTrans($root->children[$i], $trans);
            }
        }
    }
}
