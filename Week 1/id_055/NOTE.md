# NOTE

## 第三课
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
https://leetcode-cn.com/problems/rotate-array/

解法1
```js
var rotate = function(nums, k) {
    while (k) {
        nums.unshift(nums.pop())
        k--
    }
};
```

解法2
```js
var rotate = function(nums, k) {
    let n = nums.length
    
    nums.reverse()
    
    let f = nums.splice(k, n - k)
    
    f.reverse()
    
    nums.reverse()
    
    f.forEach(num => nums.push(num)) 
};
```


https://leetcode-cn.com/problems/merge-two-sorted-lists/

解法
```js
var mergeTwoLists = function(l1, l2) {
    
    let preHead = new ListNode(-1)
    
    let pre = preHead
    
    while (l1 !== null && l2 !== null) {
        if (l1.val > l2.val) {
            pre.next = l2
            l2 = l2.next
        } else {
            pre.next = l1
            l1 = l1.next
        }
        pre = pre.next
    }
    
    // 当一个有序链表遍历完毕后，将另一个链表，追加到新链表上
    pre.next = l1 === null ? l2 : l1;
    
    return preHead.next
};
```

https://leetcode-cn.com/problems/merge-sorted-array/

解法
// 1.合并，排序
// 2.双指针 (注意边界问题，m = 0 的情况)
```js
var merge = function(nums1, m, nums2, n) {
    
    let i = m-1, j = n-1, k=m+n-1
    
    while (k >= 0) {
        if (nums1[i] <= nums2[j] || nums1[i] === undefined) {
            nums1[k--] = nums2[j--]
        } else {
            nums1[k--] = nums1[i--]
        }
    }
};
```

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

https://leetcode-cn.com/problems/plus-one/


## 第四课

