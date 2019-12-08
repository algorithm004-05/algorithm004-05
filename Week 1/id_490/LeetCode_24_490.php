<?php
/**
 * 题目名称：swap-nodes-in-pairs 两两交换链表中的节点
 * 题目链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */

/**
 * 第一种解法：递归
 * @param ListNode $head
 * @return ListNode
 */
function swapPairs($head) {
    if ($head == null || $head->next == null) {
        return $head;
    }
    
    $next = $head->next;
    $head->next = swapPairs($next->next);
    $next->next = $head;
    
    return $next;
}
