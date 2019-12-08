package main

func main() {

}

/**
 * 双端队列 结构  队头、队尾均可入队
 */
type MyCircularDeque struct {
	front, rear *node
	len, cap    int
}

//节点 value 前后指针
type node struct {
	value     int
	pre, next *node
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{
		cap: k,
	}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.len == this.cap {
		return false
	}

	n := &node{
		value: value,
	}

	//如果长度为0 头、尾指向该元素
	if this.len == 0 {
		this.front = n
		this.rear = n
	} else {
		n.next = this.front
		this.front.pre = n
		this.front = n
	}
	this.len++
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.len == this.cap {
		return false
	}

	n := &node{
		value: value,
	}
	if this.len == 0 {
		this.front = n
		this.rear = n
	} else {
		n.pre = this.rear
		this.rear.next = n
		this.rear = n
	}

	this.len++

	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.len == 0 {
		return false
	}

	if this.len == 1 {
		this.front, this.rear = nil, nil
	} else {
		this.front = this.front.next
		this.front.pre = nil
	}

	this.len--
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.len == 0 {
		return false
	}

	if this.len == 1 {
		this.front, this.rear = nil, nil
	} else {
		this.rear = this.rear.pre
		this.rear.next = nil
	}
	this.len--
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.len == 0 {
		return -1
	}

	return this.front.value
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.len == 0 {
		return -1
	}

	return this.rear.value
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.len == 0
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.len == this.cap
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
