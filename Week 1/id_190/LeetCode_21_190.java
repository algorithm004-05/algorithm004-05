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
        //某个list为空 返回另一个
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //当前的值小于另一个list当前的值 则结果为下一项与另一个list合并后的值
        //递归操作
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
