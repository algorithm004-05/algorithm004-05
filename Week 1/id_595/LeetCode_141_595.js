/*
 * @lc app=leetcode.cn id=141 lang=javascript
 *
 * [141] 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (43.58%)
 * Likes:    399
 * Dislikes: 0
 * Total Accepted:    74K
 * Total Submissions: 169.3K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表，判断链表中是否有环。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能用 O(1)（即，常量）内存解决此问题吗？
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
 * @return {boolean}
 */

//  解法1：快慢指针
// 思路：使用快慢指针slow和quick，slow每次走1步，quick每次走2步，如果链表形成闭环，终归两个指针会相遇。
// 注意一些边界条件的判断
var hasCycle = function(head) {
    if(head === null || head.next === null) return false; // 空指针或者只有一个节点的链表，自然是不能形成闭环的

    let slow = head;
    let quick = head;

    while(quick !== null && quick.next !== null) {  // 为了保证quick指针的两次后移，判断当前quick和quick.next是否为null
        quick = quick.next.next;
        slow = slow.next;
        if(slow === quick) return true;
    }

    return false;
};
// @lc code=end