# NOTE

## 第 5 课

https://leetcode-cn.com/problems/valid-anagram/description/

解法 1 排序

```js
var isAnagram = function(s, t) {
  if (typeof s === 'undefined' || typeof t === 'undefined') return false;

  if (s.length !== t.length) return false;

  return (
    s
      .split('')
      .sort()
      .join() ===
    t
      .split('')
      .sort()
      .join()
  );
};
```

解法 2 HashMap

```js
var isAnagram = function(s, t) {
  if (typeof s === 'undefined' || typeof t === 'undefined') return false;

  if (s.length !== t.length) return false;

  const map = new Map();

  for (let i in s) {
    let key = map.get(s[i]);
    key !== undefined ? map.set(s[i], ++key) : map.set(s[i], 1);
  }

  for (let i in t) {
    let key = map.get(t[i]);
    if (key !== undefined) {
      map.set(t[i], --key);
    } else {
      return false;
    }
  }

  for (let value of map.values()) {
    if (value !== 0) {
      return false;
    }
  }

  return true;
};
```

解法 3 自建 HashMap

```js
var isAnagram = function(s, t) {
  if (typeof s === 'undefined' || typeof t === 'undefined') return false;

  if (s.length !== t.length) return false;

  let count = s => {
    let map = {};
    s.forEach(i => {
      let hashCode = i.charCodeAt() - 'a'.charCodeAt();
      map[hashCode] !== undefined ? (map[hashCode] += 1) : (map[hashCode] = 1);
    });

    return map;
  };

  let sM = count(s.split(''));
  let tM = count(t.split(''));

  function compareMap(sM, tM) {
    for (let key in sM) {
      if (sM[key] !== tM[key]) {
        return false;
      }
    }
    return true;
  }

  return compareMap(sM, tM);
};
```

https://leetcode-cn.com/problems/group-anagrams/

```js
var groupAnagrams = function(strs) {
  let map = new Map();

  function hash(key) {
    let m = Array.from({ length: 26 }).fill(0);

    for (let s of key) {
      let code = s.charCodeAt() - 'a'.charCodeAt();
      m[code] += 1;
    }

    return m.join('#');
  }

  for (let i = 0; i < strs.length; i++) {
    let hashCode = hash(strs[i]);
    let value = map.get(hashCode);
    value !== undefined
      ? map.set(hashCode, [...value, strs[i]])
      : map.set(hashCode, [strs[i]]);
  }

  return Array.from(map.values());
};
```

https://leetcode-cn.com/problems/two-sum/description/

```js
var twoSum = function(nums, target) {
  let map = new Map();
  for (let i = 0; i < nums.length; i++) {
    map.set(target - nums[i], i);
  }

  for (let j = 0; j < nums.length; j++) {
    let temp = map.get(nums[j]);
    if (temp !== undefined && temp !== j) {
      return [j, temp];
    }
  }
};
```

## 第 6 课

树，二叉树，二叉搜索树

二叉树中序遍历

https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

解法 1 递归

```js
var inorderTraversal = function(root) {
  let res = [];
  function traversal(node) {
    if (!node) return;
    if (node.left) traversal(node.left);
    if (node.val) res.push(node.val);
    if (node.right) traversal(node.right);
  }

  traversal(root);

  return res;
};
```

解法 2 栈

```js
var inorderTraversal = function(root) {
  let res = [],
    stack = [];

  let currNode = root;

  while (currNode || stack.length !== 0) {
    while (currNode) {
      stack.push(currNode);
      currNode = currNode.left;
    }

    currNode = stack.pop();
    res.push(currNode.val);
    currNode = currNode.right;
  }

  return res;
};
```

https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

解法 1
递归

```js
var preorderTraversal = function(root) {
  let res = [];
  function traversal(node) {
    if (!node) return;
    res.push(node.val);
    if (node.left) traversal(node.left);
    if (node.right) traversal(node.right);
  }

  traversal(root);

  return res;
};
```

解法 2
栈

```js
var inorderTraversal = function(root) {
  let res = [],
    stack = [];

  let currNode = root;

  while (currNode || stack.length !== 0) {
    while (currNode) {
      stack.push(currNode);
      currNode = currNode.left;
    }

    currNode = stack.pop();
    res.push(currNode.val);
    currNode = currNode.right;
  }

  return res;
};
```

https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

解法 1 递归

```js
var postorder = function(root) {
  let res = [];
  function helper(node) {
    if (!node) return;

    let children = node.children;

    for (let i = 0; i < children.length; i++) {
      helper(children[i]);
    }

    res.push(node.val);
  }

  helper(root);

  return res;
};
```

解法 2 stack

```js
var postorder = function(root) {
  let res = [],
    stack = [];

  stack.push(root);

  while (root && stack.length !== 0) {
    root = stack.pop();
    res.push(root.val);
    stack.push();
  }

  return res;
};
```

https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

解法 1

```js
var preorder = function(root) {
  let res = [];

  function helper(node) {
    if (node) res.push(node.val);
    let children = node.children;
    for (let i = 0; i < children.length; i++) {
      helper(children[i]);
    }
  }

  helper(root);

  return res;
};
```

解法 2

```js
var preorder = function(root) {
  let res = [],
    stack = [root];

  while (root && stack.length !== 0) {
    root = stack.pop();
    res.push(root.val);

    let children = root.children;

    for (let i = children.length - 1; i >= 0; i--) {
      stack.push(children[i]);
    }
  }

  return res;
};
```

https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal

解法

```js
var levelOrder = function(root) {
  if (!root) return [];

  let levels = [],
    queue = [root];

  while (queue.length !== 0) {
    let levelSize = queue.length;

    const currLevel = [];

    for (let i = 0; i < levelSize; i++) {
      const node = queue.shift();

      currLevel.push(node.val);

      let children = node.children;

      queue.push(...children);
    }

    levels.push(currLevel);
  }

  return levels;
};
```

## 第 7 课

递归 - 循环
通过函数体来进行循环 (自己调用自己)

### 递归 模板

```js
function recursion(level, param1, param2, ...) {
    // 递归终止条件
    if (level > MAX_LEVEL) {
        process_result
        return
    }

    // 处理逻辑, 当前层
    process(level, data...)

    // 进入下一层
    recursion(level+1, param1, param2, ...)

    // 如果需要，恢复当前层的状态(变量等)

}
```

1.抵制人肉递归的诱惑 2.找最近重复子问题 3.数学归纳法

https://leetcode-cn.com/problems/climbing-stairs/

解法 1: 傻递归

```js
var climbStairs = function(n) {
  function helper(n) {
    // 递归终止条件
    if (n === 1) {
      return 1;
    }

    if (n === 2) {
      return 2;
    }

    // 处理数据
    return helper(n - 1) + helper(n - 2);
  }

  return helper(n);
};
```

解法 2: 递归 (记忆))

```js
var climbStairs = function(n) {
  function helper(n, memo) {
    // 递归终止条件
    if (n === 1) {
      return 1;
    }

    if (n === 2) {
      return 2;
    }

    if (memo[n]) {
      return memo[n];
    }

    // 处理数据
    memo[n] = helper(n - 1, memo) + helper(n - 2, memo);

    return memo[n];
  }

  return helper(n, []);
};
```

解法 3

```js
// fn = fn-1 + fn-2
var climbStairs = function(n) {
  let f1 = 1,
    f2 = 2,
    f3;

  if (n === 1) {
    return f1;
  }

  if (n === 2) {
    return f2;
  }

  for (let i = 3; i <= n; i++) {
    f3 = f1 + f2;
    f1 = f2;
    f2 = f3;
  }

  return f2;
};
```

https://leetcode-cn.com/problems/generate-parentheses/

```js
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  const res = [];

  helper(0, 0, n, '');

  function helper(left, right, n, str) {
    // 递归终结条件
    if (left === n && right === n) {
      res.push(str);
      return;
    }

    // 处理当前层，校验合法性,

    // 下一层
    if (left < n) helper(left + 1, right, n, str + '(');
    if (left > right) helper(left, right + 1, n, str + ')');

    // 清除状态
  }

  return res;
};
```

https://leetcode-cn.com/problems/invert-binary-tree/description/
https://leetcode-cn.com/problems/validate-binary-search-tree

解法 1, 中序遍历，验证数组的是否有序

```js
var isValidBST = function(root) {
  let curr = [];
  // 中序遍历，节点的值如果是从小到大排列，就是有效的
  function helper(root) {
    // 递归终止条件 遍历到叶子节点
    if (!root) return;

    // 处理当前层的数据

    // 进入下一层
    if (root.left) helper(root.left);
    if (root.val) curr.push(root.val);
    if (root.right) helper(root.right);

    // 清除当前层状态
  }

  const isOrderedArr = arr => {
    for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] >= arr[i + 1]) return false;
    }
    return true;
  };

  helper(root);

  return isOrderedArr(curr);
};
```

解法 2: 递归过程中优化

```js
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  let lastValue = Number.MIN_SAFE_INTEGER;
  let res = true;
  // 中序遍历，节点的值如果是从小到大排列，就是有效的
  function helper(root) {
    // 递归终止条件 遍历到叶子节点
    if (!root) return;

    // 处理当前层的数据

    // 进入下一层
    if (root.left) helper(root.left);

    // 当前值与上一个值比较， 如果小于等于，说明无效
    if (root.val <= lastValue) {
      res = false;
      return;
    }
    lastValue = root.val;
    if (root.right) helper(root.right);

    // 清除当前层状态
  }

  helper(root);

  return res;
};
```

https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

```js
// 广度优先遍历
var maxDepth = function(root) {
  if (!root) return 0;

  let queue = [];
  let res = [];

  queue.push(root);

  while (queue.length !== 0) {
    let level = [];
    let queueSize = queue.length;

    for (let i = 0; i < queueSize; i++) {
      let currNode = queue.shift();

      if (currNode) {
        level.push(currNode.val);
        if (currNode.left) queue.push(currNode.left);
        if (currNode.right) queue.push(currNode.right);
      }
    }

    res.push(level);
  }

  return res.length;
};

// 深度优先遍历 1
var maxDepth = function(root) {
  if (!root) return 0;

  let maxLevel = 0;

  function helper(level, root) {
    // 递归终止条件
    if (!root) {
      return;
    }
    // 处理当前层
    maxLevel = Math.max(maxLevel, level);

    // 进入下一层
    helper(level + 1, root.left);
    helper(level + 1, root.right);

    // 清理当前层状态
  }

  helper(0, root);

  return maxLevel + 1;
};

// 深度优先遍历
var maxDepth = function(root) {
  if (!root) return 0;
  return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
};
```

https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

解法 1

```js
var minDepth = function(root) {
  if (!root) return 0;

  let minLevel = Number.MAX_SAFE_INTEGER;

  function helper(level, root) {
    if (!root) {
      return;
    }

    if (!root.left && !root.right) {
      minLevel = Math.min(minLevel, level);
    }

    helper(level + 1, root.left);
    helper(level + 1, root.right);
  }

  helper(0, root);

  return minLevel + 1;
};
```

解法 2 广度优先遍历

```js
var minDepth = function(root) {
  if (!root) return 0;

  let queue = [root],
    minLevel = Number.MAX_SAFE_INTEGER,
    level = 0;

  while (queue.length !== 0) {
    let queueSize = queue.length;

    level++;

    for (let i = 0; i < queueSize; i++) {
      let node = queue.shift();
      if (isLeaf(node)) {
        minLevel = Math.min(minLevel, level);
      } else {
        if (node.left) queue.push(node.left);
        if (node.right) queue.push(node.right);
      }
    }
  }

  return minLevel;
};

function isLeaf(node) {
  return !node.left && !node.right;
}
```

https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

## 第 8 课

分治模板

```js
function divide_conquer(problem, param1, param2, ...) {

    // 递归终止条件
    if (problem is None) {
        print_result
        return
    }

    // 处理或准备数据
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)

    // conquer subproblems
    subresult1 = divide_conquer(subproblems[0], p1, ...)
    subresult2 = divide_conquer(subproblems[1], p1, ...)
    subresult3 = divide_conquer(subproblems[2], p1, ...)

    // process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)

    // 清理状态
}
```

回溯
八皇后和数独问题

https://leetcode-cn.com/problems/powx-n/

```js
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
  if (n < 0) {
    n = -n;
    return 1 / pow(x, n);
  } else {
    return pow(x, n);
  }
};

var pow = function(x, n) {
  // x^0 = 1
  if (n === 0) {
    return 1;
  }

  let half = pow(x, Math.floor(n / 2));

  if (n % 2 === 1) {
    return half * half * x;
  } else {
    return half * half;
  }
};
```

https://leetcode-cn.com/problems/subsets/

```js
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  let ans = [];

  function helper(index, nums, list) {
    // 递归终结条件
    if (index === nums.length) {
      ans.push(list);
      return;
    }
    // 处理当前层

    // 进入下一层
    helper(index + 1, nums, list.slice(0));
    list.push(nums[index]);
    // 注意当前层的变量，需要 copy 到下一层 list.slice(0)
    helper(index + 1, nums, list.slice(0));

    // 清理状态
    list.pop();
  }

  helper(0, nums, []);

  return ans;
};
```
