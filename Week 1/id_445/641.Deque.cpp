class MyCircularDeque {
    private:
    int _size,_capacity=10;int *val;
    int front,last;
public:
///sollution 1
    /** Initialize your data structure here. Set the size of the deque to be k. */
    // MyCircularDeque(int k) {
    //     _capacity=k;
    //     val=new int[_capacity];
    //     front=_capacity-1;
    //     last=0;
    //     _size=0;
    // }

    // /** Adds an item at the front of Deque. Return true if the operation is successful. */
    // bool insertFront(int value) {
    //     if(isFull())return false;
    //     val[front]=value;
    //     front=(front-1+_capacity)%_capacity;
    //     _size++;
    //     return true;
    // }
    
    // /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    // bool insertLast(int value) {
    //     if(isFull())return false;
    //     val[last]=value;
    //     last=(last+1)%_capacity;
    //     _size++;
    //     return true;
    // }
    
    // /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    // bool deleteFront() {
    //     if(isEmpty())return false;
    //     front=(front+1)%_capacity;
    //     _size--;
    //     return true;
    // }
    
    // /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    // bool deleteLast() {
    //     if(isEmpty())return false;
    //     last=(last-1+_capacity)%_capacity;
    //     _size--;
    //     return true;
    // }
    
    // /** Get the front item from the deque. */
    // int getFront() {
    //     if (isEmpty()) return  -1;
        
    //     return val[(front+1)%_capacity];
    // }
    
    // /** Get the last item from the deque. */
    // int getRear() {
    //     if (isEmpty()) return  -1;
    //     return val[(last-1+_capacity)%_capacity];
    // }
    
    // /** Checks whether the circular deque is empty or not. */
    // bool isEmpty() {
    //     return _size==0;
    // }
    
    // /** Checks whether the circular deque is full or not. */
    // bool isFull() {
    //     return _size==_capacity;
    // }
        MyCircularDeque(int k) {
        _capacity=k;
        val=new int[_capacity];
        front=_capacity-1;
        last=0;
        _size=0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull())return false;
        val[front]=value;
        front=front==0?(_capacity-1):front-1;
        _size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(isFull())return false;
        val[last]=value;
        last=last==(_capacity-1)?0:last+1;
        _size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty())return false;
        front=front==(_capacity-1)?0:front+1;
        _size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty())return false;
        last=last==0?(_capacity-1):last-1;
        _size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty()) return  -1;
        int index=front==(_capacity-1)?0:front+1;
        return val[index];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty()) return  -1;
        int index =last==0?(_capacity-1):last-1;
        return val[index];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return _size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return _size==_capacity;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
