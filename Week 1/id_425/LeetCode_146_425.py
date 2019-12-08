#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU缓存机制
#
# https://leetcode-cn.com/problems/lru-cache/description/
#
# algorithms
# Medium (43.67%)
# Likes:    263
# Dislikes: 0
# Total Accepted:    20.1K
# Total Submissions: 46.1K
# Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' + '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
#
# 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
# 
# 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
# 写入数据 put(key, value) -
# 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
# 
# 进阶:
# 
# 你是否可以在 O(1) 时间复杂度内完成这两种操作？
# 
# 示例:
# 
# LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
# 
# cache.put(1, 1);
# cache.put(2, 2);
# cache.get(1);       // 返回  1
# cache.put(3, 3);    // 该操作会使得密钥 2 作废
# cache.get(2);       // 返回 -1 (未找到)
# cache.put(4, 4);    // 该操作会使得密钥 1 作废
# cache.get(1);       // 返回 -1 (未找到)
# cache.get(3);       // 返回  3
# cache.get(4);       // 返回  4
# 
# 
#

# @lc code=start
class LRUCache:
    class node:
        def __init__(self,value=-1, next=-1 ,pre=-1 ):
            self.value = value
            self.next = next
            self.pre = pre

    def __init__(self, capacity: int):
        self.lenth =capacity
        self.data = dict()
        headNode = self.node(-1,1,-1)
        endNode = self.node(-1,-1,self.lenth)
        self.data[0] = headNode
        self.data[self.lenth+1] = endNode     
        for i in range(self.lenth):
            self.data[i+1] = self.node(-1,i+2,i)
    def get(self, key: int) -> int:
        v = self.data.get(key)
        #v是data[key]的vlaue，是node对象或者Null 
        if v == -1:
            return -1
        else:
        #删除节点
            # #处理上节点
            # self.data[v.pre].next = v.next
            # #处理下节点
            # self.data[v.next].pre = v.pre
            self.DeleteNode(v)
        #插入头节点后
            #处理v节点
            v.pre = 0
            v.next = self.data[0].next
            #处理原始头结点后节点
            self.data[self.data[0].next].pre = key
            return v.value

    def put(self, key, value):
        NowNode = self.data.get(key)
        if NowNode.value == -1:
            #key不存在，在头节点插入，尾结点删除
            tempNode = self.node(value,self.data[0].next,0)
            self.data[key] = tempNode
            #删除尾结点之前节点
            dNodeKey = self.data[self.lenth+1].pre
            self.DeleteNode(self.data[dNodeKey])
            del self.data[self.data[self.lenth+1].pre]

        else:
            self.data[key].value = value
    def DeleteNode(self,n):
        self.data[n.pre].next = n.next
        self.data[n.next].pre = n.pre
# 出现错误，未解决-.-
# Line 45: KeyError: 1
# KeyError: 1
# Line 45 in put (Solution.py)
# Line 74 in __helper_select_method__ (Solution.py)
# Line 106 in _driver (Solution.py)
# Line 116 in <module> (Solution.py)
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

