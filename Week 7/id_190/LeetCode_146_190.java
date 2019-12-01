package com.week07;

import java.util.*;

public class LRUCache {


    private Map<Integer,Node> map = new HashMap<>();
    private Node head, tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head =new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }


    class Node {
        int key;
        int value;
        Node prev, next;
    }


    private void add(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node){
        remove(node);
        add(node);
    }

    private Node removeTail(){
        Node node = tail.prev;
        remove(node);
        return node;
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return  node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key,newNode);
            add(newNode);
            size++;

            if (size > capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }
}
