<?php
/**
 * 题目名称：design-circular-deque 设计循环双端队列
 * 题目链接：https://leetcode-cn.com/problems/design-circular-deque/
 */

class MyCircularDeque {
    private $head;
    private $tail;
    private $size;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this->head = [];
        $this->tail = [];
        $this->size = $k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        if ($this->isFull()) {
            return false;
        }
        array_push($this->head, $value);
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        if ($this->isFull()) {
            return false;
        }
        array_push($this->tail, $value);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if (empty($this->head)) {
            while(!empty($this->tail)) {
                array_push($this->head, array_pop($this->tail));
            }
        }
        if (empty($this->head)) {
            return false;
        }
        array_pop($this->head);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {
        if (empty($this->tail)) {
            while(!empty($this->head)) {
                array_push($this->tail, array_pop($this->head));
            }
        }
        if (empty($this->tail)) {
            return false;
        }
        array_pop($this->tail);
        return true;
    }

    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if (empty($this->head)) {
            while(!empty($this->tail)) {
                array_push($this->head, array_pop($this->tail));
            }
        }
        if (empty($this->head)) {
            return -1;
        }
        return $this->head[count($this->head) - 1];
    }

    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        if (empty($this->tail)) {
            while(!empty($this->head)) {
                array_push($this->tail, array_pop($this->head));
            }
        }
        if (empty($this->tail)) {
            return -1;
        }
        return $this->tail[count($this->tail) - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        return empty($this->head) && empty($this->tail);
    }

    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        return count($this->head) + count($this->tail) == $this->size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * $obj = MyCircularDeque($k);
 * $ret_1 = $obj->insertFront($value);
 * $ret_2 = $obj->insertLast($value);
 * $ret_3 = $obj->deleteFront();
 * $ret_4 = $obj->deleteLast();
 * $ret_5 = $obj->getFront();
 * $ret_6 = $obj->getRear();
 * $ret_7 = $obj->isEmpty();
 * $ret_8 = $obj->isFull();
 */

$obj = new MyCircularDeque(3);
$ret_1 = $obj->insertFront(1);
$ret_1 = $obj->insertFront(2);
$ret_2 = $obj->insertLast(3);
$ret_2 = $obj->insertLast(4);
$ret_3 = $obj->deleteFront();
$ret_4 = $obj->deleteLast();
$ret_5 = $obj->getFront();
$ret_6 = $obj->getRear();
$ret_7 = $obj->isEmpty();
$ret_8 = $obj->isFull();