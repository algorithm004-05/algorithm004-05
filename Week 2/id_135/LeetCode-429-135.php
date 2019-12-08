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
     * @return Integer[][]
     */
    function levelOrder($root) {
        $res = [];
        $level = [];

        $queue = $root ? [$root] : [];
        $nextLevelQueue= [];
        while (sizeof($queue)) {
            $i = 0;
            $l = sizeof($queue);
            while ($i < $l) {
                $node = $queue[$i];
                $level[] = $node->val;
                foreach($node->children as $child) {
                    $nextLevelQueue[] = $child;
                };
                $i++;
            };
            $res[] = $level;
            $level = [];
            $queue = $nextLevelQueue;
            $nextLevelQueue = [];
        };

        return $res;
    }
}