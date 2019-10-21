import java.util.Arrays;

public class LeetCode_21_105 {
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return head.next;

    }
}
