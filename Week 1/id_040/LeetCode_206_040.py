# 反转一个单链表。
#
# 示例:
#
# 输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL
#
# 进阶:
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        n = head
        prev = None
        while n:
            n.next, prev, n = prev, n, n.next
        return prev


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    n1 = ListNode(x=1)
    n2 = ListNode(x=2)
    n3 = ListNode(x=3)
    n4 = ListNode(x=4)
    n5 = ListNode(x=5)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    s = Solution()
    r = s.reverseList(head=n1)

    n = r
    while n:
        print(n.val)
        n = n.next
