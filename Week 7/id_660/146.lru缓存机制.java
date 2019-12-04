/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.29%)
 * Likes:    310
 * Dislikes: 0
 * Total Accepted:    24.7K
 * Total Submissions: 55.3K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );**cache.put(1,1);*cache.put(2,2);*cache.get(1); // 返回  1
*cache.put(3,3); // 该操作会使得密钥 2 作废
*cache.get(2); // 返回 -1 (未找到)
*cache.put(4,4); // 该操作会使得密钥 1 作废
*cache.get(1); // 返回 -1 (未找到)
*cache.get(3); // 返回  3
*cache.get(4); // 返回  4
***/

// @lc code=start
import java.util.Hashtable;

class LRUCache {

  class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
  }

  private void addNode(DLinkedNode node) {

    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
  }

  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode post = node.post;

    pre.post = post;
    post.pre = pre;
  }

  private void moveToHead(DLinkedNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private DLinkedNode popTail() {
    DLinkedNode res = tail.pre;
    this.removeNode(res);
    return res;
  }

  private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
  private int count;
  private int capacity;
  private DLinkedNode head, tail;

  public LRUCache(int capacity) {
    this.count = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    head.pre = null;

    tail = new DLinkedNode();
    tail.post = null;

    head.post = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }

    // 提升最近使用的key至head
    this.moveToHead(node);

    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);

    if (node == null) {

      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;

      this.cache.put(key, newNode);
      this.addNode(newNode);

      ++count;

      if (count > capacity) {
        // pop
        DLinkedNode tail = this.popTail();
        this.cache.remove(tail.key);
        --count;
      }
    } else {
      // 更新值
      node.value = value;
      this.moveToHead(node);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
