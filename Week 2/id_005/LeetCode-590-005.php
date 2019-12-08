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
class Solution
{
    /**
     * 迭代
     * 执行用时 :516 ms, 在所有 php 提交中击败了62.07%的用户
     * @param Node $root
     * @return Integer[]
     */
    public function postorder($root)
    {
        $list = [];
        if (empty($root) || !isset($root->val)) {
            return $list;
        }

        $stack = new SplStack();
        $stack->push($root);
        while (!$stack->isEmpty()) {
            $root = $stack->pop();
            $list[] = $root->val;
            foreach ($root->children as $node) {
                $stack->push($node);
            }
        }
        return array_reverse($list);
    }

    public $list = [];
    /**
     * 递归
     * 执行用时 :520 ms, 在所有 php 提交中击败了58.62%的用户
     * @param Node $root
     * @return Integer[]
     */
    public function postorderRecursive($root)
    {
        if (!isset($root)) {
            return $this->list;
        }
        foreach ($root->children as $node) {
            $this->postorder($node);
        }
        $this->list[] = $root->val;
        return $this->list;
    }
}
