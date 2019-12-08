class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.pre = None
        self.next = None


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.hkeys = {}
        # 设置一个头尾指针，和尾指针
        self.head = Node(None, -1)
        self.tail = Node(None, -1)
        self.size = 0
        self.head.next, self.tail.pre = self.tail, self.head

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """

        if key not in self.hkeys:
            return -1
        cur = self.hkeys[key]
        cur.pre.next, cur.next.pre = cur.next, cur.pre
        node = self.head.next
        self.head.next, cur.pre, cur.next, node.pre = cur, self.head, self.head.next, cur
        return self.hkeys.get(key).value

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        # 存在时修改值，并放到头的位置
        if key in self.hkeys:
            cur = self.hkeys[key]
            cur.value = value
            cur.pre.next, cur.next.pre = cur.next, cur.pre
            node = self.head.next
            self.head.next, cur.pre, cur.next, node.pre = cur, self.head, node, cur
        else:
            if self.size == self.capacity:
                tail = self.tail.pre
                self.hkeys.pop(tail.key)
                tail.pre.next, tail.next.pre = tail.next, tail.pre
                self.size -= 1
            cur = Node(key, value)
            self.hkeys[key] = cur
            node = self.head.next
            self.head.next, cur.next, cur.pre, node.pre = cur, node, self.head, cur
            self.size += 1
            # 删除最后一个元素

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)