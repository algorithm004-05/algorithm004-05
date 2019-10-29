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
        // // 链表重要的操作——插入和删除
        // // ListNode dummyHead = new ListNode(0);
        // // ListNode cur = dummyHead;
        // //若某一链表不为空，则展开合并
        // while (l1 != null && l2 != null) {
        //     if (l1.val < l2.val) {
        //         cur.next = l1;
        //         cur = cur.next;
        //         l1 = l1.next;
        //     } else {
        //         cur.next = l2;
        //         cur = cur.next;
        //         l2 = l2.next;
        //     }
        // }
        // //l1和l2任一为空，直接连接另一条链表
        // if (l1 == null){
        //     cur.next = l2;
        // } else {
        //     cur.next = l1;
        // }
        // return dummyHead.next;


        // 参考国际站，java，4行代码，使用recursion,虽然代码简洁，但是这样的递归可能造成Stack Overflow
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
// @lc code=end

