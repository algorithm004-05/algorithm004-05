<?php
/**
 * 题目名称：reverse-linked-list 反转链表
 * 题目链接：https://leetcode-cn.com/problems/reverse-linked-list/
 */

/**
 * 第一种解法：迭代法
 * @param ListNode $head
 * @return ListNode
 */
function reverseList($head) {
    $curr = $head;
    $prev = null;
    while ($curr != null) {
        $nextTemp = $curr->next;
        $curr->next = $prev;
        $prev = $curr;
        $curr = $nextTemp;
    }
    return $prev;
}
