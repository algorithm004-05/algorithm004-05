# -*- encoding: utf-8 -*-
"""
    package.module
    ~~~~~~~~~~~~~~

    LeetCode 第21题: 合并两个有序链表

    :copyright: (c) 2019-10-17 by liuyajing.
    :license: OPS, see LICENSE_FILE for more details.
"""


# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
#
# 示例：
#
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
#
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 首先确定头节点
        ln = None
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val <= l2.val:
            ln = l1
            l1 = l1.next
        else:
            ln = l2
            l2 = l2.next

        # 确定各个节点的下一个节点
        p = ln
        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next

            p = p.next

        if l1 is not None:
            p.next = l1
        else:
            p.next = l2

        # 最终返回头节点，从而就可以找到所有的节点
        return ln

# leetcode submit region end(Prohibit modification and deletion)
