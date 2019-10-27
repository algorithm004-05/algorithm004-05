package Question21MergeTwoLists;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 6, 8, 23, 34, 56, 77, 90};
//        int[] arr2 = {-90, 34, 55, 79, 87, 98, 123, 234, 567};
        int[] arr1 = {1, 3, 4};
        int[] arr2 = {1, 2, 4};

        ListNode root1 = new ListNode();
        ListNode root2 = new ListNode();
        ListNode root3 = new ListNode();

        getLink(arr1, root1);
        getLink(arr2, root2);
        mergeLink(root1, root2, root3);

        viewLink(root1);
        viewLink(root2);
        viewLink(mergeLink(root1, root2));
    }

    private static void mergeLink(ListNode root1, ListNode root2, ListNode root3) {
        if ((root2.getNext() != null) && (root1.getNext() == null || root1.getValue() >= root2.getValue())) {
            //链表1的头结点的值大于链表2的头结点的值
            root3.setValue(root2.getValue());
            root3.setNext(new ListNode());
            root2 = root2.getNext();
            root3 = root3.getNext();
            mergeLink(root1, root2, root3);
        }
        if ((root1.getNext() != null) && (root2.getNext() == null || root1.getValue() < root2.getValue())) {
            //链表2的头结点的值大于链表1的头结点的值
            root3.setValue(root1.getValue());
            root3.setNext(new ListNode());
            root1 = root1.getNext();
            root3 = root3.getNext();
            mergeLink(root1, root2, root3);
        }
    }

    /**
     * 输出链表
     */
    private static void viewLink(ListNode root) {
        while (root.getValue() != null) {
            System.out.print(root.getValue() + "===>");
            root = root.getNext();
        }
        System.out.print("end");
        System.out.println();
    }

    /**
     * 构建链表
     */
    private static void getLink(int[] arr, ListNode root) {
        for (int i = 0; i < arr.length; i++) {
            root.setValue(arr[i]);
            root.setNext(new ListNode());
            root = root.getNext();
        }
    }

    /**
     * 合并链表
     */
    private static ListNode mergeLink(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l2 == null && l1 != null)
            return l1;
        ListNode newHead = new ListNode(-1);//定义头结点
        ListNode r = newHead;
        while (l1.next != null && l2.next != null) {
//        while (l1!= null && l2!= null) {
            //l1.next=null 和 l1=null有什么区别？
            if (l1.val < l2.val) {
                r.next = l1; //这里，将待排序节点直接拼接在新节点后，而不用再创建新节点。节省了空间复杂度。
                r = r.next;
                l1 = l1.next;
            } else {
                r.next = l2;
                r = r.next;
                l2 = l2.next;
            }
        }
        if (l1.next != null) r.next = (l1);
        if (l2.next != null) r.next = (l2);
        return newHead.next;
    }
}























