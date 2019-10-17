#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class ListNode(object):

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):

    @staticmethod
    def detectCycle(head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        slow = fast = finder = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                while finder != slow:
                    finder = finder.next
                    slow = slow.next
                return finder
        return None

if __name__ == '__main__':
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(3)
    d = ListNode(4)
    a.next = b
    b.next = c
    c.next = a
    print(Solution.detectCycle(a))
