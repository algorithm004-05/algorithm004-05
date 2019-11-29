# NOTE

### 位运算

https://leetcode-cn.com/problems/number-of-1-bits/

解法 1

```js
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  let count = 0;
  for (let i = 0; i < 32; i++) {
    if (n % 2 === 1) {
      count++;
    }

    // 注意整除
    n = Math.floor(n / 2);

    if (n === 0) break;
  }

  return count;
};
```

解法 2 位远算

```js
var hammingWeight = function(n) {
  let count = 0;
  for (let i = 0; i < 32; i++) {
    // 判断是否是奇数
    if (n & (1 === 1)) {
      count++;
    }

    // 左移一位 相当于除以 2
    n = n >> 1;

    if (n === 0) break;
  }

  return count;
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
  return n > 0 && (n & (n - 1)) === 0;
};
```

https://leetcode-cn.com/problems/reverse-bits/

```js
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  return Number.parseInt(
    n
      .toString(2)
      .padStart(32, 0)
      .split('')
      .reverse()
      .join(''),
    2
  );
};
```

https://leetcode-cn.com/problems/n-queens/description/
https://leetcode-cn.com/problems/n-queens-ii/description/
https://leetcode-cn.com/problems/counting-bits/description/

### Bloom filter

https://llimllib.github.io/bloomfilter-tutorial/zh_CN/

https://www.youtube.com/watch?v=zWPsH1Aw4Es

https://www.youtube.com/watch?v=qCVHH0NtIl4

JS 简单实现， 关键在于 Hash 函数，这里的实现非常渣

```js
class bloomFilter {
  constructor(size) {
    this.size = size;
    this.storage = new Array(size).fill(0, 0);
  }

  add(str) {
    this.storage[this.hashIt(str, this.size)] = 1;
    this.storage[this.hashIt2(str, this.size)] = 1;
    this.storage[this.hashIt3(str, this.size)] = 1;
  }

  contains(str) {
    return (
      !!this.storage[this.hashIt(str, this.size)] &&
      !!this.storage[this.hashIt2(str, this.size)] &&
      !!this.storage[this.hashIt3(str, this.size)]
    );
  }

  hashIt(str, size) {
    let coded = 0;
    for (let i = 0; i < str.length; i++) {
      coded += str[i].charCodeAt() * i + 1;
    }
    return Math.floor(coded % size);
  }

  hashIt2(str, size) {
    let coded = 0;
    for (let i = 0; i < str.length; i++) {
      coded += (str[i].charCodeAt() - i) * i + 1;
    }
    return Math.floor((coded * 2) % size);
  }

  hashIt3(str, size) {
    let coded = 0;
    for (let i = 0; i < str.length; i++) {
      coded += (str[i].charCodeAt() + i) * i + 1;
    }
    return Math.floor((coded * 3) % size);
  }
}
```

其它实现 https://github.com/bitpay/bloom-filter/blob/master/lib/filter.js

### LRU

HashTable + 双向链表

https://leetcode-cn.com/problems/lru-cache/submissions/

利用 Map 会记录添加的元素的顺序的特点

```js
/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity
    this.map = new Map()
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (this.map.has(key)) {
        const value = this.map.get(key)
        this.map.delete(key)
        this.map.set(key, value)  
        return value
    } else {
        return -1
    }
   
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if (this.map.has(key)) {
        this.map.delete(key)
    } else {
        if (this.map.size === this.capacity) {
            let iterator = this.map.keys();
            this.map.delete(iterator.next().value)
        }
    }
    this.map.set(key, value)
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
```