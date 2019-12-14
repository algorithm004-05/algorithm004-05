# NO.1
[](https://leetcode.com/problems/design-circular-deque)
解法

```
    class MyCircularDeque {
        int front = 0, rear = -1, len = 0, k = 0; 
        int[] arr; 
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k]; 
            this.k = k; 
        }
        
        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) return false; 
            front = --front % k;
            if (front < 0) front += k; 
            arr[front] = value;
            len++; 
            if (len == 1) rear = front; 
            return true; 
        }
        
        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) return false; 
            rear = ++rear % k; 
            arr[rear] = value;
            len++;
            return true; 
        }
        
        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) return false; 
            front = ++front % k;
            len--;
            return true; 
        }
        
        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) return false; 
            rear = --rear % k;
            if (rear < 0) rear += k; 
            len--; 
            return true; 
        }
        
        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : arr[front]; 
        }
        
        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : arr[rear]; 
        }
        
        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return len == 0; 
        }
        
        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return len == k; 
        }
    }
```




# NO.2
[](https://leetcode.com/problems/trapping-rain-water/)


```
    class Solution {
    public:
        int trap(vector<int>& height) {
            int cnt = height.size();
            int left_max = 0;
            int right_max = 0;
            int sum = 0;
            vector<int>::iterator biggest_r;
            for (int i=1; i<cnt-1;i++) { // 最左和最右不需要计算
                if (left_max + right_max == 0) { // 初始化
                    biggest_r = std::max_element(std::begin(height)+i+1, std::end(height));
                    left_max = height[0];
                    right_max = *biggest_r;
                } else {
                    left_max = max(left_max, height[i-1]); //左边max一直要更新
                    if (height[i] == right_max) { 
                        //右边max只有当向右遍历时移走的是当前右边最大的才更新right_max，否则不需要更新
                        biggest_r = std::max_element(std::begin(height)+i+1, std::end(height));
                        right_max = *biggest_r;
                    }   
                }
                sum += max(min(left_max, right_max) - height[i],0);
            }
            return sum;
        
        }
    };
```
