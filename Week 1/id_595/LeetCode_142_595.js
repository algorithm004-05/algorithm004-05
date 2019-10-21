/*
 * @lc app=leetcode.cn id=142 lang=javascript
 *
 * [142] 环形链表 II
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (44.70%)
 * Likes:    256
 * Dislikes: 0
 * Total Accepted:    33.2K
 * Total Submissions: 73.8K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 
 * 说明：不允许修改给定的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：
 * 你是否可以不用额外空间解决此题？
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

//  解法1： 双指针找到快慢指针的相遇点，然后再用一个指针p从head触发，slow从相遇点出去，p和slow都每次走1步，
// 当p和slow相遇的时候，再次相遇点就是环的起点
var detectCycle = function(head) {
    if(head === null || head.next === null) return null;

    let quick = head;
    let slow = head;
    let p = head;

    while(quick !== null && quick.next !== null) { // 寻找slow和quick的相遇点
        quick = quick.next.next;
        slow = slow.next;
        if(slow === quick) {
            break;
        }
    }

    if(quick !== null && quick.next !== null) { // 判断是否有环，如果有环
        while(p !== slow) {     // p从head出发，slow从相遇点出发，p和slow每次走1步，再次相遇的时候就是「环的起点」
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
    
    return null;
};
// @lc code=end

