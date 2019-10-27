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
        $god = json_decode(json_encode($root->children,JSON_PRETTY_PRINT,10000),true,10000);
        $arr = [];
        $arr[] = $root->val;
        while($god) {
            $val = array_shift($god);
            if(!empty($val['children'])) {
                foreach(array_reverse($val['children']) as $kids) {
                    array_unshift($god, $kids);
                }
            }
            $arr[] = $val['val'];
        }
        return $arr;
    }
}