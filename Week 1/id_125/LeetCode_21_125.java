import java.util.List;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.19 20:48
 * @Description:
 */
public class A21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;

        System.out.println(mergeTwoLists(l11, l21));


    }

    /**
     * 通过比较大小，对指针的next进行拼接。
     * 把pre的next指向自身，自身的next指向下一个节点即可
     * 时间：O(n) 没有嵌套，跟两个链表的长度有关系
     * 空间：O(1) 只会存在少数几个指针
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 建立头，方便查找
        ListNode head = new ListNode(Integer.MIN_VALUE);

        // 建立pre节点
        ListNode preNode = head;
        while (l1 != null && l2 != null) {

            // 比较大小
            if (l1.val >= l2.val) {
                // 把上一节点的指针指过去
                preNode.next = l2;

                // 并且移动当前指针到next
                l2 = l2.next;
            } else {
                preNode.next = l1;
                l1 = l1.next;
            }
            // 同时移动pre节点至新节点
            preNode = preNode.next;
        }

        preNode.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
