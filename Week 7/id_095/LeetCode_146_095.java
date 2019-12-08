/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (28.63%)
 * Likes:    4026
 * Dislikes: 166
 * Total Accepted:    391.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

// @lc code=start
class LRUCache {
  
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;
    
    public LRUCache(int _capacity) {
      capacity = _capacity;
      head.next = tail;
      tail.prev = head;
    }
  
    public int get(int key) {
      if(map.containsKey(key)) {
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
      } else {
        return -1;
      }
    }
  
    public void put(int key, int value) {
      if(map.containsKey(key)) {
        remove(map.get(key));
      }
      if(map.size() == capacity) {
        remove(tail.prev);
      }
      insert(new Node(key, value));
    }
    
    private void remove(Node node) {
      map.remove(node.key);
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    
    private void insert(Node node){
      map.put(node.key, node);
      Node headNext = head.next;
      head.next = node;
      node.prev = head;
      headNext.prev = node;
      node.next = headNext;
    }
    
    class Node{
      Node prev, next;
      int key, value;
      Node(int _key, int _value) {
        key = _key;
        value = _value;
      }
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

