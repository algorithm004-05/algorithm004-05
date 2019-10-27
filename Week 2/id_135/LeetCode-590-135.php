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
    function postorder($root) {
        $stack = array($root);
        $res = [];
        while(!empty($stack)){
            $node = array_pop($stack);
            $res[] = $node->val;
            foreach($node->children as $n){
                $stack[] = $n;
            }
        }
        return array_reverse($res);
    }
}
