#!/anaconda3/bin/python

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class LeetCode_21_495(object):

    def mergeTwoLists(self, l1, l2):
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

if __name__ == '__main__':
    a = ListNode(11)
    ab = ListNode(2)
    ac = ListNode(3)
    ad = ListNode(4)
    ad = ListNode(4)
    a.next = ab
    ab.next = ac
    ac.next = ad
    b = ListNode(55)
    bb = ListNode(6)
    bc = ListNode(7)
    bd = ListNode(8)
    be = ListNode(9)
    bf = ListNode(10)
    bg = ListNode(12)
    b.next = bb
    bb.next = bc
    bc.next = bd
    bd.next = be
    be.next = bf
    bf.next = bg
    c = LeetCode_21_495().mergeTwoLists(a,b)
    while c.next:
        print(c.val)
        c = c.next
