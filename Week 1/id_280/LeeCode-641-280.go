package main

func main() {
	tt := new(MyCircularDeque).Constructor(3)
	tt.InsertFront(1)
	tt.InsertFront(2)
	tt.InsertLast(3)
}

type DoubleListNode struct {
	pre  *DoubleListNode
	next *DoubleListNode
	val  int

}

type MyCircularDeque struct {
	size int
	k    int
	head *DoubleListNode
	tail *DoubleListNode
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func (this *MyCircularDeque) Constructor(k int) *MyCircularDeque {
	this.head      = &DoubleListNode{val: -1}
	this.tail      = &DoubleListNode{val: -1}
	this.head.pre  = this.tail
	this.tail.next = this.head
	this.size      = 0
	this.k         = k
	return this
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.size == this.k {
		return  false
	}
	node              := &DoubleListNode{val: value}
	node.next          = this.head
	node.pre           = this.head.pre
	this.head.pre.next = node
	this.head.pre      = node
	this.size++

	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.size == this.k {
		return false
	}
	node              := &DoubleListNode{val: value}
	node.next          = this.tail.next
	this.tail.next.pre = node
	this.tail.next     = node
	node.pre           = this.tail
	this.size++

	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.size == 0 {
		return false
	}
	this.head.pre.pre.next = this.head
	this.head.pre          = this.head.pre.pre
	this.size--

	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.size == 0 {
		return false
	}
	this.tail.next.next.pre = this.tail
	this.tail.next          = this.tail.next.next
	this.size--

	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	return this.head.pre.val
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	return this.tail.next.val
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.size == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.size == this.k
}
