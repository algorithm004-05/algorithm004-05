#
# [21] 合并两个有序链表
# @lc app=leetcode.cn id=21 lang=python3
# 执行用时：44 ms 超过95.40%
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
        
class Solution:
    # 目前只学到了1种解题方法
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        prehead = ListNode(-1)
        mp = prehead
        while l1 and l2:
            # l1节点值 小于 l2节点值 ，新链表都以l1节点为主
            if l1.val <= l2.val:
                mp.next, l1 = l1, l1.next
            else:
                mp.next, l2 = l2, l2.next
            # 哨兵节点移动
            mp = mp.next
        # l1链表如果是空，结果直接返回l2链表，反之亦然
        mp.next = l1 if l1 is not None else l2
        return prehead.next
    