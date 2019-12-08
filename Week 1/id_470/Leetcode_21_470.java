/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val > p2.val){
                tail.next = p2;
                p2 = p2.next;
            }else{
                tail.next = p1;
                p1 = p1.next;
            }
            tail  = tail.next;
        }

        if(p1!=null){
            tail.next = p1;
        }

        if(p2!=null){
            tail.next = p2;
        }

        return head.next;
    }
}