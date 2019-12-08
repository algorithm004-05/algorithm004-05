/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.36%)
 * Likes:    2769
 * Dislikes: 405
 * Total Accepted:    716.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
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

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }
        
        ListNode pre = null;
        ListNode res = null;

        if(l1.val<l2.val){
            pre = l1;
            l1 = l1.next;
        }else{
            pre = l2;
            l2 = l2.next;
        }

        res = pre;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
                
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return res;
    }
        
    
}


// @lc code=end

