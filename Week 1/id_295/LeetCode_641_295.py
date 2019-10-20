class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.deque = [0] * (k + 1)
        self.head = 0
        self.tail = 0
        self.k = k + 1

    def next(self, pointer):
        return (pointer + 1) % self.k

    def pre(self, pointer):
        return (pointer - 1 + self.k) % self.k

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull(): return False
        self.deque[self.head] = value
        self.head = self.next(self.head)
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull(): return False
        self.tail = self.pre(self.tail)
        self.deque[self.tail] = value
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.head = self.pre(self.head)
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.tail = self.next(self.tail)
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty(): return -1
        return self.deque[self.pre(self.head)]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty(): return -1
        return self.deque[self.tail]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.head == self.tail

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.tail == self.next(self.head)

# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
