/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (64.92%)
 * Likes:    611
 * Dislikes: 0
 * Total Accepted:    108.9K
 * Total Submissions: 167.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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
 * @return {ListNode}
 */

// 解法1： 申请一个额外的数组arr，遍历一遍链表将每个node放入arr，然后倒序弹出node，将node链接起来
var reverseList = function(head) {
    if(head === null || head.next === null) return head;
    
    let arr = [];
    let p = head;
    let newHead, q;
    let flag = 1;    // 用于判断新创建的node是不是第一个
    while(p !== null) { // 遍历链表，每个node放入数据arr
        arr.push(p);
        p = p.next;
    }

    while(arr.length !== 0) {
        let node = arr.pop();
        if(flag) {
            newHead = node;
            q = newHead;
            flag = 0;
        } else {
            q.next = node;
            q = node;
        }
    }
    q.next = null;
    return newHead;
};

// 解法2：三指针法。运用三个指针p，q，k倒着改变指针指向，以k是否为null为终止条件，最后结束后，还要加一步: q.next = p
var reverseList = function(head) {
    if(head === null || head.next === null) return head;

    let p = null;
    let q = head;
    let k = head.next;

    while(k !== null) {
        q.next = p;
        p = q;
        q = k;
        k = k.next;
    }
    q.next = p;
    return q;
};
// @lc code=end

