package algorithm00405test.week1.job.done;


import java.util.Stack;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_21_510 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode head = l2;
        Stack<ListNode> nodes = new Stack<ListNode>();
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                nodes.push(l1);
                l1 = l1.next;
            } else {
                nodes.push(l2);
                l2 = l2.next;
            }
        }
        if (null != l1) {
            head = l1;
        } else if (null != l2) {
            head = l2;
        } else {
            head = null;
        }
        ListNode temp;
        while (0 < nodes.size()) {
            temp = nodes.pop();
            temp.next = head;
            head = temp;
        }
        return head;
    }

    /**
     * 递归
     *
     * 心得
     * 不足：1："重复性"没有形成思维方式
     *      2：递归运用不熟练
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
        ListNode first = (l2.val < l1.val) ? l2 : l1;
        first.next = mergeTwoLists2(first.next, first == l1 ? l2 : l1);
        return first;

    }


    /**
     *
     * @param l1
     * @return
     */
    private static ListNode reverseLinked(ListNode l1) {
        ListNode head = l1;
        ListNode temp = l1.next;
        l1.next = null;
        while (null != temp) {
            l1 = temp;
            temp = temp.next;
            l1.next = head;
            head = l1;
        }
        return l1;
    }


}
