//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;

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
        ListNode node = new ListNode(-1);
        ListNode re=node;
        while(l1.next!=null&&l1.next!=null){
            if(l1.val<=l2.val) {
                node.next=l1;
                l1=l1.next;
            }else{
                node.next=l2;
                l2=l2.next
            }
            node=node.next;
        }
        if(l1.next!=null) node.next=l1;
        if(l2.next!=null) node.next=l2;
        return re.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
