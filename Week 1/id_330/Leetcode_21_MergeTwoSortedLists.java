public class Leetcode_21_MergeTwoSortedLists {


    public static void main(String[] args) {

    }

//    TODO: 串糖葫芦，比较谁小，谁串到新链表上去
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(-1);
        ListNode pre = temp;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;

        return temp.next;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

//         TODO：对于不知道长度并且需要比较的多数情况下可以使用递归完成
        if (l1 == null) {

            return l2;
        }else if (l2 == null) {

            return l1;
        }else if (l1.val > l2.val) {

            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }