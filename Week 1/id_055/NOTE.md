# NOTE

## 第三课
### Array 实战题目

https://leetcode.com/problems/climbing-stairs/

解法
```js
var climbStairs = function(n) {
    
    if (n === 1) {
        return 1
    }
    
    let f3, f2 = 2, f1 = 1
    
    for (let i=3; i<=n; i++) {
        f3 = f2 + f1
        f1 = f2
        f2 = f3
    }
    
    return f2
};
```


https://leetcode-cn.com/problems/container-with-most-water/

解法1 枚举
```js
var maxArea = function(height) {
    let maxArea = 0
    for (let i=0; i<height.length - 1; i++) {
        for (let j=i+1; j<height.length; j++) {
              let temp = Math.min(height[i], height[j])*(j-i);
              temp > maxArea ? maxArea = temp : null
        }
    }
    
    return maxArea
};
```

解法2 双指针
```js
var maxArea = function(height) {
    let i = 0, j = height.length - 1, res = 0
    while (j-i >= 1) {
        if (height[i] > height[j]) {
           res = Math.max(res, height[j] * (j - i))
           j-- 
        } else {
           res = Math.max(res, height[i] * (j - i))
           i++
        }
    } 
    
    return res
}
```


https://leetcode-cn.com/problems/two-sum/
解法1
```js
var twoSum = function(nums, target) {
    for (let i=0; i<nums.length; i++) {
        for (let j=i+1; j<nums.length; j++) {
           if (nums[i] + nums[j] === target) {
               return [i,j]
           } 
        }
    }
};
```
解法2
```js 
var twoSum = function(nums, target) {
    let map = new Map()
    for (let i=0; i<nums.length; i++) {
        map.set(nums[i], i)
    }
    
    for (let j=0; j<nums.length; j++) {
        const otherIndex = map.get(target - nums[j])
        if (otherIndex !== undefined && otherIndex !== j) return [j, otherIndex]
    }
};
```

解法3
```js
var twoSum = function(nums, target) {
    let map = new Map()
    for (let i=0; i<nums.length; i++) {
        const otherIndex = map.get(target - nums[i])
        if (otherIndex !== undefined) return [otherIndex, i]
        map.set(nums[i], i)
    }
};
```

https://leetcode-cn.com/problems/move-zeroes/

解法1
```js
var moveZeroes = function(nums) {
    let i = 0
    let zeros = 0
    
    while(i < nums.length) {
        if (nums[i] === 0) {
           nums.splice(i,1) 
           zeros++
        } else {
           i++   
        }
    }
    
    while (zeros) {
        nums.push(0)
        zeros--
    }
    
};
```

解法2 (老师的解法)
```js
var moveZeroes = function(nums) {
    let j = 0
    for (let i=0; i<nums.length; i++) {
        if (nums[i] !== 0) {
           nums[j] = nums[i]
           if (i !== j) {
              nums[i] = 0
           }
           j++
        } 
    }
};
```

https://leetcode-cn.com/problems/3sum/ (高频老题）

解法:

```js
var threeSum = function(nums) {
    let ans = [];
    const len = nums.length;
    if(nums == null || len < 3) return ans;
    nums.sort((a, b) => a - b); // 排序
    
    for (let i = 0; i < len ; i++) {
        if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
        if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
        let L = i+1;
        let R = len-1;
        while(L < R){
            const sum = nums[i] + nums[L] + nums[R];
            if (sum == 0) {
                ans.push([nums[i],nums[L],nums[R]]);
                while (L<R && nums[L] == nums[L+1]) L++; // 去重
                while (L<R && nums[R] == nums[R-1]) R--; // 去重
                L++;
                R--;
            } else if (sum < 0) { 
                L++;
            } else if (sum > 0) {
                R--;
            }
        }
    }        
    return ans;
};
```

### 链表

https://leetcode.com/problems/reverse-linked-list/

解法
```js
var reverseList = function(head) {
    let currNode = head, preNode = null
   
    while (currNode) {
       [currNode.next, preNode, currNode] = [preNode, currNode, currNode.next]
    }
    
    return preNode
};
```

https://leetcode.com/problems/swap-nodes-in-pairs

解法
```js
var swapPairs = function(head) {
   
    let preNode = new ListNode(-1)
    
    preNode.next = head
    
    currNode = preNode
    
    while (currNode.next && currNode.next.next ) {
        let a = currNode.next
        let b = a.next
        
        currNode.next = b
        a.next = b.next
        b.next = a
       
        currNode = a
    }
    
    return preNode.next
    
};
```

https://leetcode.com/problems/linked-list-cycle

解法
```js
var hasCycle = function(head) {
    
    // 使用 set 集合
    
//     let currNode = head, set = new Set()
    
//     while (currNode) {
//         if (set.has(currNode)) {
//             return true
//         }
//         set.add(currNode)
//         currNode = currNode.next
//     }
    
//     return false
    
    // 使用快慢指针
    
    let fast = slow = head
    
    while (fast && fast.next ) {
        
        fast = fast.next.next
        slow = slow.next
        
        if (fast === slow) {
           return true 
        }
    }
    
    return false
};
```

https://leetcode.com/problems/linked-list-cycle-ii
https://leetcode.com/problems/reverse-nodes-in-k-group/

```js
var reverseKGroup = function(head, k) {
    let preNode = new ListNode(-1)
    let tmp = preNode
    
    while (true) {
        let n = k, currNode = head, stack = []
        
        while (n && currNode) {
            stack.push(currNode)
            currNode = currNode.next
            n--
        }
        
        if (n !== 0 ) {
            tmp.next = head
            break
        }
        
        while (stack.length) {
            tmp.next = stack.pop()
            tmp = tmp.next
        }
        
        head = currNode
    }
    
    return preNode.next
        
};
```


## 第四课

### 栈和队列

https://leetcode-cn.com/problems/valid-parentheses/

解法
```js
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const map = {
        "}":"{",
        ")":"(",
        "]":"["
    }
    
    const stack = []
    
    for (let i=0; i<s.length; i++) {
        let temp = map[s[i]]
        if (temp) {
            let top = stack.pop();
            if (top !== temp) {
                return false;
            }
        } else {
            stack.push(s[i])
        }
    }
    
    return stack.length === 0
    
};
```

https://leetcode-cn.com/problems/min-stack/

解法
···js
/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.arr = []
    this.minArr = [] 
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.arr.push(x)
    let minTop = this.minArr[this.minArr.length - 1]
    if (minTop === undefined || minTop >= x ) {
        this.minArr.push(x)
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    let top = this.arr.pop()
    let minTop = this.minArr[this.minArr.length - 1]
    
    if (top === minTop) {
        this.minArr.pop()
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
   return this.arr[this.arr.length - 1]
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minArr[this.minArr.length - 1]
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
···

https://leetcode-cn.com/problems/largest-rectangle-in-histogram/submissions/

解法1 暴力
```js
var largestRectangleArea = function(heights) {
    let maxArea = 0
    for (let i=0; i<heights.length; i++) {
        for(let j=i; j<heights.length; j++) {
            
            // 找出i与j之间柱子的最小值
            let minHieght = Number.MAX_SAFE_INTEGER
            
            for (let k = i; k <= j; k++) {
                minHieght = Math.min(heights[k], minHieght)
            }
            let area = (j-i+1) * minHieght
            maxArea = area > maxArea ? area : maxArea;
        }
    }
    
    return maxArea
};
```

解法2 暴力 优化

```js
// 暴力 优化
var largestRectangleArea = function(heights) {
    let maxArea = 0
    for (let i=0; i<heights.length; i++) {
        // 柱子的最小值
        let minHieght = Number.MAX_SAFE_INTEGER

        for(let j=i; j<heights.length; j++) {
            // 每次获取两个柱子中的最小值，也就保证了，随着 J 增加，minHeight 始终是 i 与 j 之间的最小值
            minHieght = Math.min(heights[j], minHieght)        
            let area = (j-i+1) * minHieght
            maxArea = area > maxArea ? area : maxArea;
        }
    }
    
    return maxArea
};
```

解法3 栈

```js
//  栈
var largestRectangleArea = function(heights) {
   
    let maxArea = 0
    let stack = []
    stack.push(-1)
    
    for (let i=0; i<heights.length; i++) {
        while (stack[stack.length-1] !== -1 && heights[stack[stack.length-1]] >= heights[i]) {
           maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack[stack.length-1] - 1));
        }
        stack.push(i)
    }
    
    while (stack[stack.length-1] !== -1) {
        maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack[stack.length-1] -1));
    }
    return maxArea
};
```

https://leetcode-cn.com/problems/sliding-window-maximum/

解法1
```js
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    if(!nums) return []
    
    let window = [], res = []
    
    nums.forEach((n,i) => { 
        
        if ( i >= k && window[0] <= i-k) {
           window.shift() 
        }
        
        while (window.length !== 0 && nums[window[window.length-1]] <= n) {
            window.pop()
        }
        
        window.push(i)

        
        if (i >= k - 1) {
           res.push(nums[window[0]]) 
        }
    })
    
    return res
};
```

解法2
```js
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
   let window = []
   let res = []
    
   for (let i = 0; i < nums.length; i++) {
        if (i < k - 1) {
            window.push(nums[i]);
        } else { // 窗口开始向前滑动
            window.push(nums[i]);
            res.push(Math.max(...window));
            window.shift();
        }
    }
    
    return res
    
};
```
