<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {
    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        if ($l1 == null) {
            return $l2;
        }
        if ($l2 == null) {
            return $l1;
        }
        
        $head = null;
        if ($l1->val <= $l2->val) {
            $head = $l1;
            $l1 = $l1->next;
        } else {
            $head = $l2;
            $l2 = $l2->next;
        }
        $l3 = $head;

        while ($l1 != null && $l2 != null) {
            if ($l1->val <= $l2->val) {
                $head->next = $l1;
                $l1 = $l1->next;
            } else {
                $head->next = $l2;
                $l2 = $l2->next;
            }
            $head = $head->next;
        }
        if ($l1 == null) {
            $head->next = $l2;
        } elseif ($l2 == null) {
            $head->next = $l1;
        }
        return $l3;
    }
}