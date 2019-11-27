# NOTE

### 位运算

https://leetcode-cn.com/problems/number-of-1-bits/

解法1
```js
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0
    for (let i=0; i<32; i++) {
        if (n%2 === 1) {
            count++
        }

        // 注意整除
        n = Math.floor(n/2)

        if (n === 0) break;
    }

    return count
};
```

解法2 位远算 

```js
var hammingWeight = function(n) {
    let count = 0
    for (let i=0; i<32; i++) {
        // 判断是否是奇数
        if (n&1 === 1) {
            count++
        }

        // 左移一位 相当于除以 2
        n = n >> 1

        if (n === 0) break;
    }

    return count
};
```

https://leetcode-cn.com/problems/power-of-two/

```js
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    // 注意运算符运算顺序 https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Operator_Precedence
    return n > 0 && (n & n - 1) === 0
};
```
https://leetcode-cn.com/problems/reverse-bits/
https://leetcode-cn.com/problems/n-queens/description/
https://leetcode-cn.com/problems/n-queens-ii/description/
https://leetcode-cn.com/problems/counting-bits/description/

