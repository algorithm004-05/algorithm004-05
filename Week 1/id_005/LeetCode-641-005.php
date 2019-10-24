<?php

class MyCircularDeque
{
    private $count;
    private $length;
    private $arr;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    public function __construct($k)
    {
        $this->length = $k;
        $this->count = 0;
        $this->arr = [];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    public function insertFront($value)
    {
        if ($this->count == $this->length) {
            return false;
        }
        array_unshift($this->arr, $value);
        $this->count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    public function insertLast($value)
    {
        if ($this->count == $this->length) {
            return false;
        }
        array_push($this->arr, $value);
        $this->count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    public function deleteFront()
    {
        if (empty($this->count)) {
            return false;
        }
        array_shift($this->arr);
        $this->count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    public function deleteLast()
    {
        if (empty($this->count)) {
            return false;
        }
        array_pop($this->arr);
        $this->count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     * @return Integer
     */
    public function getFront()
    {
        if (empty($this->count)) {
            return -1;
        }
        return $this->arr[0];
    }

    /**
     * Get the last item from the deque.
     * @return Integer
     */
    public function getRear()
    {
        if (empty($this->count)) {
            return -1;
        }
        return $this->arr[$this->count-1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    public function isEmpty()
    {
        return empty($this->count);
    }

    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    public function isFull()
    {
        return $this->count == $this->length;
    }
}
