<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution
{

    /**
     * 执行用时 :4 ms, 在所有 php 提交中击败了85.71%的用户
     * @param ListNode $head
     * @param Integer $m
     * @param Integer $n
     * @return ListNode
     */
    public function reverseBetween($head, $m, $n)
    {
        if ($head == null) {
            return null;
        }
        // 创建一个虚拟节点以标记此列表的开头
        $dummy = new ListNode();
        $dummy->next = $head;
        // 在反转之前，用 pre 标记该节点
        $pre = $dummy;
        for ($i = 0; $i < $m-1; $i++) {
            $pre = $pre->next;
        }
        $start = $pre->next; // 指向要被反转的列表的第一个节点 1
        $then = $start->next; // 指向要被反转的列表的第一个节点的指针 2

        for ($i = 0; $i < $n-$m; $i++) {
            $start->next = $then->next; // 1->3 1->4 1->5
            $then->next = $pre->next; // 2->1 3->2 4->3
            $pre->next = $then; // 0->2 0->3 0->4
            $then = $start->next;
        }

        return $dummy->next;
    }
}
