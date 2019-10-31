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
     * 执行用时 :484 ms, 在所有 php 提交中击败了100.00%的用户
     * 利用栈，一边取出一边放入
     * @param Node $root
     * @return Integer[]
     */
    public function preorder($root)
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
        return $list;
    }

    public $list = [];
    /**
     * 递归
     * 执行用时 :468 ms, 在所有 php 提交中击败了100.00%的用户
     * @param Node $root
     * @return Integer[]
     */
    public function preorderRecursive($root)
    {
        if (!isset($root)) {
            return $this->list;
        }
        $this->list[] = $root->val;
        foreach ($root->children as $node) {
            $this->preorder($node);
        }
        return $this->list;
    }
}
