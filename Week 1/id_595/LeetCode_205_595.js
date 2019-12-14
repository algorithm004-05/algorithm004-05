/*
 * @lc app=leetcode.cn id=25 lang=javascript
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (54.64%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    24.2K
 * Total Submissions: 44.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

//  思路：将链表分为三部分，「已反转的链表」、「待反转的链表」和「未反转的链表」。
// 初始化可以申请一个「哨兵节点」作为「已反转的链表」，然后申请两个指针pre和end，指向「已反转的链表」的末尾，
// 同时申请一个指针start，指向「待反转的链表」的开头，要反转k个，就让end指针向后遍历k次。此处有个判断，如果此时遍历的个数小于k，则break。
// 整个大循环的条件是「end.next !== null」，然后截断start到end的链表，通过「end.next = null」截断。然后通过「反转链表」的函数，将start到end
// 的链表进行反转。
var reverseKGroup = function(head, k) {
    let newHead = new ListNode(0);
    let pre = newHead;
    let end = newHead;

    newHead.next = head;

    while(end.next !== null) {
        for(let i = 0; i < k && end !== null; i++) end = end.next;
        if(end === null) break;
        let start = pre.next;
        let next = end.next;

        end.next = null; // 阶段start到end部分的链表
        pre.next = reverse(start);
        start.next = next;
        pre = start;

        end = pre;
    }
    return newHead.next;
};

// 这里就是反转链表的代码
function reverse(head) {
    if(head === null || head.next === null) return head;

    let pre = null;
    let cur = head;

    while(cur !== null) {
        let next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }

    return pre;
}
// @lc code=end

