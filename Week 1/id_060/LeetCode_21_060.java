/*
  21
  Merge two sorted linked lists and return it as a new list.
  The new list should be made by splicing together the nodes of the first two lists.

  Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
*/

public class MergeTwoSortedLists {

  private static class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
    ListNode preHead = new ListNode(-1);
    ListNode explorer = preHead;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        explorer.next = l1;
        l1 = l1.next;
      } else {
        explorer.next = l2;
        l2 = l2.next;
      }
      explorer = explorer.next;
    }

    explorer.next = l1 == null ? l2 : l1;
    return preHead.next;
  }

  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists1(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists1(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    if (l1.val <= l2.val) {
      l1.next = mergeTwoLists3(l1.next, l2);
    } else {
      l2.next = mergeTwoLists3(l1, l2.next);
    }

    return l1.val <= l2.val ? l1 : l2;
  }
}
