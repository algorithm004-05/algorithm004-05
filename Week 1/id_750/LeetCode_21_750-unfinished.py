"""
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        pass


if __name__ == '__main__':
    solution = Solution()
    l1 = [1, 2, 4]
    l2 = [1, 3, 4]
    result = solution.mergeTwoLists(l1, l2)
    print(result)
