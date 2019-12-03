/*
  146
  Design and implement a data structure for Least Recently Used (LRU) cache.
  It should support the following operations: get and put.

  get(key) - Get the value (will always be positive) of the key
  if the key exists in the cache, otherwise return -1.

  put(key, value) - Set or insert the value if the key is not already present.

  When the cache reached its capacity,
  it should invalidate the least recently used item before inserting a new item.

  The cache is initialized with a positive capacity.

  Follow up:
    Could you do both operations in O(1) time complexity?

  Example:
    LRUCacheFirst cache = new LRUCacheFirst( 2 /* capacity * / );
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
*/

import java.util.HashMap;

public class LRUCacheFirst {

  private static class Node {

    int key, value;
    Node pre, next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private static class DoubleList {

    private Node head, tail;
    private int size;

    DoubleList() {
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);

      head.next = tail;
      tail.pre = head;

      this.size = 0;
    }

    void addFirst(Node x) {
      x.next = head.next;
      x.pre = head;

      head.next.pre = x;
      head.next = x;

      size++;
    }

    void remove(Node x) {
      x.pre.next = x.next;
      x.next.pre = x.pre;
      size--;
    }

    Node removeLast() {
      if (tail.pre == head) {
        return null;
      }

      Node last = tail.pre;
      remove(last);
      return last;
    }

    int getSize() {
      return size;
    }
  }

  private HashMap<Integer, Node> map;
  private DoubleList cache;
  private int capacity;

  public LRUCacheFirst(int capacity) {
    this.map = new HashMap<>();
    this.cache = new DoubleList();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    int val = map.get(key).value;

    put(key, val);
    return val;
  }

  public void put(int key, int val) {
    Node x = new Node(key, val);

    if (map.containsKey(key)) {
      cache.remove(map.get(key));
      cache.addFirst(x);
      map.put(key, x);
    } else if (capacity == cache.getSize()) {
      Node last = cache.removeLast();
      map.remove(last.key);
    } else {
      cache.addFirst(x);
      map.put(key, x);
    }
  }
}

