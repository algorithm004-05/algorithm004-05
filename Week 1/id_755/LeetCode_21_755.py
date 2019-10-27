# time complexity: O(n)
# space complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_head = ListNode(-1)
        curr_pointer = dummy_head
        p1 = l1
        p2 = l2
        while p1 is not None and p2 is not None:
            if p1.val <= p2.val:
                curr_pointer.next = p1
                p1 = p1.next
            else:
                curr_pointer.next = p2
                p2 = p2.next
            curr_pointer = curr_pointer.next
        while p1 is not None:
            curr_pointer.next = p1
            p1 = p1.next
            curr_pointer = curr_pointer.next
        while p2 is not None:
            curr_pointer.next = p2
            p2 = p2.next
            curr_pointer = curr_pointer.next
        return dummy_head.next
