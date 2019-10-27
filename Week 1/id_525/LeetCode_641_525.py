class Node(object):
    def __init__(self, value):
        self.value = value
        self.pre = None
        self.next = None

    def __str__(self):
        return '{}'.format(self.value)

    __repr__ = __str__


class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.length = 0
        self.head, self.tail = Node(None), Node(None)
        self.head.next, self.tail.pre = self.tail, self.head

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if not self.isFull():
            node = Node(value)
            next_node = self.head.next
            self.head.next, next_node.pre, node.pre, node.next = node, node, self.head, next_node
            self.length += 1
            return True
        return False

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if not self.isFull():
            node = Node(value)
            pre_node = self.tail.pre
            self.tail.pre, pre_node.next, node.pre, node.next = node, node, pre_node, self.tail
            self.length += 1
            return True
        return False

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if not self.isEmpty():
            del_node = self.head.next
            self.head.next, del_node.next.pre = del_node.next, self.head
            del_node.pre, del_node.next = None, None
            self.length -= 1
            return True
        return False

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if not self.isEmpty():
            del_node = self.tail.pre
            self.tail.pre, del_node.pre.next = del_node.pre, self.tail
            del_node.pre, del_node.next = None, None
            self.length -= 1
            return True
        return False

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.head.next.value

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.tail.pre.value

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.length == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.length >= self.size

