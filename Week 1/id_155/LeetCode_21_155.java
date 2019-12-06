/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
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
        ListNode prevHead = new ListNode(0);
        ListNode tmp = prevHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prevHead.next = l1;
                l1 = l1.next;
            }else{
                prevHead.next = l2;
                l2 = l2.next;
            }
            prevHead = prevHead.next;
        }
        prevHead.next = l1 == null ? l2 : l1;
        return tmp.next;
    }
}
// @lc code=end

