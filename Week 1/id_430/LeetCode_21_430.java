// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved. 

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head = null;
    ListNode p = l1;
    ListNode q = l2;
    ListNode tail = null;
    while (p != null && q != null) {
      ListNode node;
      if (p.val <= q.val) {
        node = p;
        p = p.next;
      } else {
        node = q;
        q = q.next;
      }
      if (head == null) {
        head = node;
      } else {
        tail.next = node;
      }
      // 别忘了
      tail = node;
    }
    if (p != null) {
      tail.next = p;
    }
    if (q != null) {
      tail.next = q;
    }
    return head;
  }
}