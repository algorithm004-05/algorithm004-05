/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (57.64%)
 * Likes:    666
 * Dislikes: 0
 * Total Accepted:    125.4K
 * Total Submissions: 217.1K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

//  解法1：建立一个「哨兵头指针」，然后双指针遍历两个目标链表，比较大小
var mergeTwoLists = function(l1, l2) {
    let p = l1;
    let q = l2;

    let newHead = new ListNode(0); // 建立一个哨兵头指针
    let k = newHead;

    while(p !== null && q !== null) {
        if(p.val < q.val) {
            k.next = p; 
            p = p.next;
        } else {
            k.next = q;
            q = q.next;
        }
        k = k.next;
    }

    k.next = (p === null) ? q : p;
    return newHead.next;
};
// @lc code=end

