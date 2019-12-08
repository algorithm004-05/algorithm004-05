import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start

// 方法一，使用系统函数库中的 LinkedHashMap
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }
}

// 方法二，手动实现，双向LinkedList+HashMap(双向链表+哈希表)
// class LRUCache {
//     class DLinkedNode {
//         int key;
//         int value;
//         DLinkedNode prev;
//         DLinkedNode next;
//     }

//     private void addNode (DLinkedNode node) {
//     /**
//      * Always add the new node right after head.
//      */
//         node.prev = head;
//         node.next = head.next;

//         head.next.prev = node;
//         head.next = node;

//     }

//     private void removeNode (DLinkedNode node) {
//     /**
//      * Remove an existing node from the linked list.
//      */
//         DLinkedNode prev = node.prev;
//         DLinkedNode next = node.next;

//         prev.next = next;
//         prev.prev = prev;
//     }

//     private void moveToHead(DLinkedNode node) {
//             /**
//      * Move certain node in between to the head.
//      */
//         removeNode(node);
//         addNode(node);
//     }

//     private DLinkedNode popTail() {
//         /**
//          * Pop the current tail.
//          */
//         DLinkedNode res = tail.prev;
//         removeNode(res);
//         return res;
//     }

//     HashMap<Integer, DLinkedNode> cache = new HashMap<>();
//     int size;
//     int capacity;
//     DLinkedNode head, tail;

//     public LRUCache(int capacity) {
//         this.size = 0;
//         this.capacity = capacity;

//         head = new DLinkedNode();
//         // head.prev = null

//         tail = new DLinkedNode();
//         // tail.next = null

//         head.next = tail;
//         tail.prev = head;
//     }
    
//     public int get(int key) {
//         DLinkedNode node = cache.get(key);
//         if(node == null) return -1;

//         // move the accessed node to the head
//         moveToHead(node);

//         return node.value;
//     }
    
//     public void put(int key, int value) {
//         DLinkedNode node = cache.get(key);

//         if (node == null) {
//             DLinkedNode newNode = new DLinkedNode();
//             newNode.key = key;
//             newNode.value = value;

//             cache.put(key, newNode);
//             addNode(newNode);

//             ++size;

//             if (size > capacity) {
//                 // pop the tail
//                 DLinkedNode tail = popTail();
//                 cache.remove(tail.key);
//                 --size;
//             }
//         } else {
//             // update the value
//             node.value = value;
//             moveToHead(node);
//         }
//     }
// }





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

