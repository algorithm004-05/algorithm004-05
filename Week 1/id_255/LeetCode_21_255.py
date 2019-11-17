# 21. 合并两个有序链表
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 法1
        if l1 and l2:
            if l1.val > l2.val: 
                l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l2, l1.next)
        return l1 or l2

        # 法2 
        prehead = ListNode(-1)
        prev = prehead
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next            
            prev = prev.next
        prev.next = l1 if l1 is not None else l2

        return prehead.next