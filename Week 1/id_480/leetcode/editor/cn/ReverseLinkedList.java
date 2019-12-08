//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode second = new Solution.ListNode(2);
        Solution.ListNode third = new Solution.ListNode(3);
        head.next = second;
        second.next = third;
        Solution.ListNode forth = new Solution.ListNode(4);
        third.next = forth;
        forth.next = new Solution.ListNode(5);
        Solution solution = new Solution();
        Solution.ListNode rs = solution.reverseList(head);
        while(rs != null) {
            System.out.println(rs);
            rs = rs.next;
        }

    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }

            @Override
            public String toString() {
                return "ListNode{" +
                        "val=" + val +
                        '}';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}