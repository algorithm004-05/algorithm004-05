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
     * recursion
     * 执行用时 :8 ms, 在所有 php 提交中击败了79.52%的用户
     * @param ListNode $head
     * @return ListNode
     */
    public function reverseListRecursion($head)
    {
        if ($head->next == null) {
            return $head;
        }
        $p = $this->reverseList($head->next);
        $head->next->next = $head;
        $head->next = null;
        return $p;
    }

    /**
     * 迭代
     * 执行用时 :4 ms, 在所有 php 提交中击败了95.24%的用户
     * @param ListNode $head
     * @return ListNode
     */
    public function reverseList($head)
    {
        $p = null;
        $curr = $head;
        while ($curr != null) {
            $nextTemp = $curr->next;// 临时存储链表
            $curr->next = $p; // 从此处开始反转
            $p = $curr; // 反转的结果
            $curr = $nextTemp; // 还没反转的内容
        }
        return $p;
    }
}
