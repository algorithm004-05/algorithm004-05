//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)

import JiKe.App;

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
        //利用一个头节点保存首部
        App.ListNode pHead = new App.ListNode(0);
        //利用一个节点往后赋值
        App.ListNode prev = pHead;
        while(l1!=null && l2 != null) {
            if(l1.val <= l2.val) {
                //l1小了。将l1的值赋值到prev后。
                prev.next = l1;
                l1 = l1.next;
                //l1切换到下个节点
            }else {
                //l2小了，将l2的值赋值到prev后。
                prev.next = l2;
                l2 = l2.next;
                //l2切换到下个节点
            }
            //这一次的prev.next确定了，切换到下一个prev节点
            prev = prev.next;
        }
        //若l1或l2长度不相等，那么。将有剩下节点的指针直接放到prev后面即可 （题中l1,l2已排序）
        prev.next = l1 == null ? l2 : l1;

        return pHead.next;
    }
    //这个题有个更简单的解法如下,还没太弄懂
    //主要思想是判断l1 和 l2的值那个更小，将其后面的节点地址断开，赋上当前节点的下一个节点和另一个链表节点比较完成的值(以此递归)
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2){
// 		if(l1 == null) return l2;
// 		if(l2 == null) return l1;
// 		if(l1.val < l2.val){
// 			l1.next = mergeTwoLists(l1.next, l2);
// 			return l1;
// 		} else{
// 			l2.next = mergeTwoLists(l1, l2.next);
// 			return l2;
// 		}
// }
}
//leetcode submit region end(Prohibit modification and deletion)
