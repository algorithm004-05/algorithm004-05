# @author:leacoder
# @des:  递归  合并两个有序链表

'''

重复处理单元：
比较两个链表节点值
将

递归终止条件：
两个链表都是空的

递归前处理（递归到下一层前处理）：
比较当前层 哪个链表头节点较小，递归找这个链表的下一个

递归（递归到下一层）：


递归后处理（下层递归返回后处理）：
返回较小值

'''

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val<l2.val:
            l1.next = self.mergeTwoLists(l1.next,l2)
            return l1 
        else:
            l2.next = self.mergeTwoLists(l1,l2.next)
            return l2
			
			
# @author:leacoder
# @des:  迭代  合并两个有序链表


'''
利用哨兵简化操作
prehead= ListNode(-1)

重复处理单元：
比较大小，将小的加入 prev

迭代终止条件：
两个链表任意一个为空

迭代前处理：
记录prev = prehead

迭代处理：
判断大小，加入prev的链表

迭代后处理：
处理 l1 或 l2 中剩余节点

'''

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 利用哨兵简化操作
        prehead= ListNode(-1)
        # 迭代前处理：
        prev = prehead # prev 用于迭代 这里记录表头 用于返回
        # 迭代终止条件：
        while l1 and l2:  #  两个链表任意一个为空
            # 迭代处理
            # 重复处理单元：
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next 
            prev = prev.next 
        # 迭代后处理：
        '''
        if l1 is not None:
            prev.next = l1
        else:
            prev.next = l2
        '''
        prev.next = l1 if l1 is not None else l2
        return prehead.next