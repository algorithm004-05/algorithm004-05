# NOTE

## 第三课
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
https://leetcode-cn.com/problems/rotate-array/
https://leetcode-cn.com/problems/merge-two-sorted-lists/
https://leetcode-cn.com/problems/merge-sorted-array/
https://leetcode-cn.com/problems/two-sum/
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

