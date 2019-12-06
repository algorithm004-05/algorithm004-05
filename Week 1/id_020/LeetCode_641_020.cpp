// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/move-zeroes/
// https://leetcode.com/problems/move-zeroes/

// Question:
// 641. 设计循环双端队列

// Solution:
// 思路: 这类设计题就是要多练习，这里是使用数组来实现循环双端队列，一定要注意头尾索引的位置就好


class MyCircularDeque {
private:
    vector<int> buff; //存储数组
    int size; // 容量
    int front;
    int rear;
    int cur;  
    
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k):buff(k, 0), size(k), front(k - 1), rear(0), cur(0){
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (cur == size) return false;
        
        cur++;
        buff[front] = value;
        front = (front - 1 + size) % size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (cur == size) return false;
        
        cur++;
        buff[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (0 == cur) return false;
        
        cur--;
        front = (front + 1) % size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (0 == cur) return false;
        
        cur--;
        rear = (rear - 1 + size) % size;
        return true;  
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (cur == 0) return -1;
        return buff[(front + 1) % size];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (cur == 0) return -1;
        return buff[(rear - 1 + size) % size];
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        //return 0 | cur;
        return 0 == cur;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        //return cur & size;
        return cur == size;
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
void leetcode_test_283(void) {
    MyCircularDeque* obj = new MyCircularDeque(10);
    bool param_1 = obj->insertFront(12);
    bool param_2 = obj->insertLast(21);
    bool param_3 = obj->deleteFront();
    bool param_4 = obj->deleteLast();
    int param_5 = obj->getFront();
    int param_6 = obj->getRear();
    bool param_7 = obj->isEmpty();
    bool param_8 = obj->isFull();
}