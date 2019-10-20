/*
 *
 * [21] 合并两个有序链表
 */

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
var mergeTwoLists = function (l1, l2) {
  if (!l1) return l2
  if (!l2) return l1
  if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2)
    return l1
  }
  l2.next = mergeTwoLists(l1, l2.next)
  return l2
};
/**
 * 耗时：84ms 击败73.73%
 * 内存：35.3mb
 * 时间复杂度O（n+m） 链表中每个元素都遍历一遍
 */
// ------------------------------------------
var mergeTwoLists = function (l1, l2) {
  let preHead = new ListNode(-1)
  let pre = preHead
  while (l1 && l2) {
    if (l1.val < l2.val) {
      pre.next = l1
      l1 = l1.next
    } else {
      pre.next = l2
      l2 = l2.next
    }
    pre = pre.next
  }
  pre.next = l1 ? l1 : l2
  return preHead.next
};
/**
 * 耗时：76ms 击败89.48%
 * 内存：35.4mb
 * 时间复杂度O（n+m） while 循环的次数等于两个链表的总长度
 */
// ------------------------------------------