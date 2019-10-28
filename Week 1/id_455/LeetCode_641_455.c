/*
 * @lc app=leetcode.cn id=641 lang=c
 *
 * [641] 设计循环双端队列
 */

// @lc code=start



typedef struct {
    int *val;
    short size, front, rear;
} MyCircularDeque;

/** Initialize your data structure here. Set the size of the deque to be k. */

MyCircularDeque* myCircularDequeCreate(int k) {
    MyCircularDeque *obj = (MyCircularDeque*)calloc(1,sizeof(MyCircularDeque));
    obj -> val = (int*)calloc(k + 1, sizeof(int));
    obj -> size = k + 1;
    return obj;
}


/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    if(obj -> front == obj -> rear){
        return true;
    }
    return false;
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
    if(obj -> rear == (obj -> front + 1) % obj -> size){
        return true;
    }
    return false;
}
/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if(myCircularDequeIsFull(obj)) return false;

    obj -> front = (obj -> front + 1) % obj -> size;
    obj -> val[obj -> front] = value;

    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if(myCircularDequeIsFull(obj)) return false;

    obj -> val[obj -> rear] = value;
    obj -> rear = (obj -> rear + obj -> size - 1) % obj -> size;

    return true;
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if(myCircularDequeIsEmpty(obj)) return false;

    obj -> front = (obj -> front + obj -> size - 1) % obj -> size;

    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if(myCircularDequeIsEmpty(obj)) return false;

    obj -> rear = (obj -> rear + 1) % obj -> size;
    
    return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
    if(myCircularDequeIsEmpty(obj)) return -1;

    return obj->val[obj -> front];
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
    if(myCircularDequeIsEmpty(obj)) return -1;

    int last = (obj -> rear + 1) % obj -> size;

    return obj->val[last];
}



void myCircularDequeFree(MyCircularDeque* obj) {
    free(obj -> val);
    free(obj);
}

/**
 * Your MyCircularDeque struct will be instantiated and called as such:
 * MyCircularDeque* obj = myCircularDequeCreate(k);
 * bool param_1 = myCircularDequeInsertFront(obj, value);
 
 * bool param_2 = myCircularDequeInsertLast(obj, value);
 
 * bool param_3 = myCircularDequeDeleteFront(obj);
 
 * bool param_4 = myCircularDequeDeleteLast(obj);
 
 * int param_5 = myCircularDequeGetFront(obj);
 
 * int param_6 = myCircularDequeGetRear(obj);
 
 * bool param_7 = myCircularDequeIsEmpty(obj);
 
 * bool param_8 = myCircularDequeIsFull(obj);
 
 * myCircularDequeFree(obj);
*/
// @lc code=end

