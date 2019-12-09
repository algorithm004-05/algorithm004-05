<?php
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution
{
    /**
     * 快慢指针
     * @param ListNode $head
     * @return boolean
     */
    public function hasCycle($head)
    {
        if ($head == null || $head->next == null) {
            return false;
        }
        $slow = $head;
        $fast = $head->next;
        while ($fast != $slow) {
            if ($fast == null || $fast->next == null) {
                return false;
            }
            $slow = $slow->next;
            $fast = $fast->next->next;
        }
        return true;
    }

    /**
     * 迭代
     * @param ListNode $head
     * @return boolean
     */
    public function hasCycle($head)
    {
        while ($head != null) {
            if ($head == $head->next) {
                return true;
            }
            if ($head->next != null) {
                $head->next = $head->next->next;
            }
            $head = $head->next;
        }
        return false;
    }
}

class ListNode
{
    public $val;
    public $next;
    public function __construct($val = 0, $next = null)
    {
        $this->val  = $val;
        $this->next = $next;
    }
}

class List
{
    public $val;
    public $next;

    public function __construct($arrs, $p = -1)
    {
        $this->val = $arrs[0];
        $pre = $this;
        for ($i = 1; $i < count($arrs); $i++) {
            $pre->next = new ListNode();
            $pre->next->val = $arrs[$i];
            $pre = $pre->next;
            if ($p == 1 && $i == count($arrs) - 1) {
                $pre->next = $this->next;
            }
            if ($p == 0 && $i == count($arrs) - 1) {
                $pre->next = $this;
            }
        }
    }
}
