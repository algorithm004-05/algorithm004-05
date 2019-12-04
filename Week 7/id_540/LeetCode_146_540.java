package com.company;

import java.util.HashMap;

public class LeetCode_146_540 {
    class LRUCache {
        DoubleLinkedListNode head;
        DoubleLinkedListNode tail;
        HashMap<Integer, DoubleLinkedListNode> map;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            head = new DoubleLinkedListNode();
            tail = new DoubleLinkedListNode();
            head.next = tail;
            tail.previous = head;

            map = new HashMap<>(capacity);
            size = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            DoubleLinkedListNode node = map.get(key);
            moveToFront(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DoubleLinkedListNode node = map.get(key);
                node.value = value;
                moveToFront(node);
            } else {
                DoubleLinkedListNode node = new DoubleLinkedListNode();
                node.key = key;
                node.value = value;
                addNode(node);
            }
        }

        private void moveToFront(DoubleLinkedListNode node) {
            removeNode(node);
            addNode(node);
        }

        private void addNode(DoubleLinkedListNode node) {
            if (size == capacity) {
                removeLastNode();
            }

            node.previous = head;
            node.next = head.next;
            head.next = node;
            node.next.previous = node;

            map.put(node.key, node);

            size++;
        }

        private void removeLastNode() {
            if (tail.previous != head) {
                removeNode(tail.previous);
            }
        }

        private void removeNode(DoubleLinkedListNode node) {
            DoubleLinkedListNode previous = node.previous;
            DoubleLinkedListNode next = node.next;
            previous.next = next;
            next.previous = previous;

            map.remove(node.key);

            size--;
        }

        private class DoubleLinkedListNode {
            int key;
            int value;
            DoubleLinkedListNode previous;
            DoubleLinkedListNode next;
        }
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
