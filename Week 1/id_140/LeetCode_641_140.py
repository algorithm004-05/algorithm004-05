#
# [641] 设计循环双端队列
# @lc app=leetcode.cn id=641 lang=python3
#
# 执行用时：88 ms 超过81.45%

# @lc code=start
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.deque = []

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.deque) < self.size :
            self.deque.insert(0,value)
            return True
        return False

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.deque) < self.size :
            self.deque.append(value)
            return True
        return False

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.deque) > 0:
            self.deque.pop(0)
            return True
        return False

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.deque) > 0:
            self.deque.pop()
            return True
        return False

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if len(self.deque) > 0:
            return self.deque[0]
        return -1

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if len(self.deque) > 0 :
            return self.deque[-1]        
        else:
            return -1

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        
        if len(self.deque) == 0 :
            return True   
        else:
            return False
        

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        
        if len(self.deque) == self.size:
            return True
        else:
            return False