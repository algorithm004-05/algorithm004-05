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
    public $level = 0;
    public $values = [];
    /**
     * 递归 看题解
     * 执行用时 :480 ms, 在所有 php 提交中击败了100%的用户
     * @param Node $root
     * @return Integer[][]
     */
    public function levelOrder($root)
    {
        if (is_null($root)) {
            return $this->values;
        }
        if (!isset($this->values[$this->level])) {
            $this->values[$this->level] = [];
        }
        $this->values[$this->level][] = $root->val;
        foreach ($root->children as $child) {
            $this->level++;
            $this->levelOrder($child);
            $this->level--;
        }

        return $this->values;
    }
    /**
     * 数组
     * 执行用时 :528 ms, 在所有 php 提交中击败了71.88%的用户
     * @param Node $root
     * @return Integer[][]
     */
    public function levelOrder($root)
    {
        $list = [];
        if (empty($root)) {
            return $list;
        }
        $queue = [$root];
        while (count($queue) > 0) {
            $temp = [];
            $count = count($queue);
            for ($i = 0; $i < $count; $i++) {
                $root = array_shift($queue);
                $temp[] = $root->val;
                foreach ($root->children as $children) {
                    $queue[] = $children;
                }
            }
            $list[] = $temp;
        }
        return $list;
    }

    /**
     * 队列
     * 执行用时 :512 ms, 在所有 php 提交中击败了78.13%的用户
     * @param Node $root
     * @return Integer[][]
     */
    public function levelOrderQueue($root)
    {
        $list = [];
        if (empty($root)) {
            return $list;
        }
        $queue = new SplQueue();
        $queue->enqueue($root);
        while (!$queue->isEmpty()) {
            $temp = [];
            $count = $queue->count();
            for ($i = 0; $i < $count; $i++) {
                $root = $queue->dequeue();
                $temp[] = $root->val;
                foreach ($root->children as $children) {
                    $queue->enqueue($children);
                }
            }
            $list[] = $temp;
        }
        return $list;
    }
}
