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

链表

https://leetcode.com/problems/reverse-linked-list/
https://leetcode.com/problems/swap-nodes-in-pairs
https://leetcode.com/problems/linked-list-cycle
https://leetcode.com/problems/linked-list-cycle-ii
https://leetcode.com/problems/reverse-nodes-in-k-group/


## 第四课

