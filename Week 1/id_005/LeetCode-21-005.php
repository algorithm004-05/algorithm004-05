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
     * 递归
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    public function mergeTwoLists($l1, $l2)
    {
        if ($l1 === null) {
            return $l2;
        }
        if ($l2 === null) {
            return $l1;
        }

        $newList = null;
        if ($l1->val < $l2->val) {
            $newList = $l1;
            $newList->next = $this->mergeTwoLists($l1->next, $l2);
        } else {
            $newList = $l2;
            $newList->next = $this->mergeTwoLists($l1, $l2->next);
        }
        return $newList;
    }

    /**
     * 迭代
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    public function mergeTwoListsTwo($l1, $l2)
    {
        $preHead = new ListNode(-1);
        $pre = $preHead;
        while ($l1 && $l2) {
            if ($l1 < $l2) {
                $pre->next = $l1;
                $l1 = $l1->next;
            } else {
                $pre->next = $l2;
                $l2 = $l2->next;
            }
            $pre = $pre->next;
        }

        $pre->next = $l1 ? $l1 : $l2;
        return $preHead->next;
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

class ListNode
{
    public $val;
    public $next;

    public function __construct($arrs)
    {
        $this->val = $arrs[0];
        $pre = $this;
        for ($i=1; $i < count($arrs) ; $i++) {
            $pre->next = new ListNode();
            $pre->next->val = $arrs[$i];
            $pre = $pre->next;
        }
    }
}
