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
     * 迭代
     * 执行用时 :4 ms, 在所有 php 提交中击败了97.37%的用户
     * @param ListNode $head
     * @return ListNode
     */
    public function swapPairs($head)
    {
        if ($head == null || $head->next == null) {
            return $head;
        }
        $cur = $head;// 当前要反转的节点 1
        $newHead = $head->next;// 指向头结点的下一个节点 2
        // 循环置换的前提 必须有节点而且不止一个
        while ($cur != null && $cur->next != null) {
            $tmp = $cur;// 存放当前要反转的节点 1
            $cur = $cur->next; // 要反转的节点的下一个节点 2
            $tmp->next = $cur->next;//先将要反转的节点指向它的下一个节点  1->3
            $cur->next = $tmp;// 再将要反转的节点原来的下一个节点改成指向要反转的节点 2->1
            $cur = $tmp->next;// 再将要置换的节点移到当前节点的下一个节点 $cur = 3

            if ($cur != null && $cur->next != null) {
                $tmp->next = $cur->next;// 1->4 这样 3 就没有前置节点了
            }
        }
        return $newHead;
    }

    /**
     * 递归
     * 执行用时 :8 ms, 在所有 php 提交中击败了75.44%的用户
     * @param ListNode $head
     * @return ListNode
     */
    public function swapPairsRecursion($head)
    {
        // 递归终止条件 无节点 或者只剩下一个
        if ($head == null || $head->next == null) {
            return $head;
        }
        // 处理本层逻辑
        // 保存头结点的下一个节点
        $n = $head->next;
        // 去到下一层 头结点指向下下个节点
        $head->next = $this->swapPairs($head->next->next);
        // 清扫当前层数据 原头结点的下个节点指向头结点
        $n->next = $head;
        return $n;
    }
}
