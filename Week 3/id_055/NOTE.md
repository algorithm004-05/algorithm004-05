# NOTE

## 第 9 课

广度优先搜索 （模板）

```js
let visited = new Set();

function BFS(graph, start, end) {
  queue = [];
  queue.push(start);
  visited.add(start);

  while (queue.length !== 0) {
    node = queue.shift();
    visited.add(node);

    process(node);
    nodes = generate_related_nodes(node);
    queue.push(nodes);

    // other processing work
  }
  // ...
}
```

深度优先搜索 （模板）

```js
// 递归
let visited = new Set();

function dfs(node, visited) {
  // terminator
  if (visited.has(node)) {
    // already visited
    return;
  }

  visited.add(node);
  // process current node here.
  //	...
  for (let i = 0; i < node.children.length; i++) {
    let next_node = node.children[i];
    if (!visited.has(next_node)) {
      dfs(next_node, visited);
    }
  }
}
// 使用 stack

function DFS(root) {
  if (!root) return [];

  let visited = [],
    stack = [root];

  while (stack.length !== 0) {
    let node = stack.pop();

    visited.add(node);

    process(node);

    nodes = generate_related_nodes(node);

    stack.push(nodes);
  }
  // other processing work
}
```

https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description

解法 1 广度

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
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root) return [];

  let queue = [root],
    res = [];

  while (queue.length !== 0) {
    let size = queue.length,
      currLevel = [];
    for (let i = 0; i < size; i++) {
      let node = queue.shift();
      currLevel.push(node.val);

      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }

    res.push(currLevel);
  }

  return res;
};
```

解法 2 深度

```js
var levelOrder = function(root) {
  if (!root) return [];
  let res = new Map();

  function helper(level, root) {
    if (!root) {
      return;
    }

    let currLevel = res.has(level) ? res.get(level) : [];
    res.set(level, [...currLevel, root.val]);

    if (root.left) helper(level + 1, root.left);
    if (root.right) helper(level + 1, root.right);
  }

  helper(0, root);

  return Array.from(res.values());
};
```

https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description

解法 广度优先遍历

```js
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
  let bankSet = new Set(bank);

  // 当结果不在目标里，直接返回 -1
  if (!bankSet.has(end)) {
    return -1;
  }

  let changes = new Map();

  changes.set('A', 'TCG');
  changes.set('T', 'ACG');
  changes.set('C', 'ATG');
  changes.set('G', 'ATC');

  let queue = [{ node: start, count: 0 }];

  while (queue.length !== 0) {
    let n = queue.shift();
    let node = n.node;
    if (node === end) {
      return n.count;
    }

    for (let i = 0; i < node.length; i++) {
      let change = changes.get(node[i]);

      for (let j = 0; j < change.length; j++) {
        let arr = node.split('');

        arr[i] = change[j];

        let newNode = arr.join('');

        if (bankSet.has(newNode)) {
          queue.push({ node: newNode, count: n.count + 1 });
          bankSet.delete(newNode);
        }
      }
    }
  }

  return -1;
};
```

https://leetcode-cn.com/problems/generate-parentheses/#/description

```js
var generateParenthesis = function(n) {
  let res = [];
  function helper(left, right, n, str) {
    if (left === n && right === n) {
      res.push(str);
      return;
    }

    if (left < n) helper(left + 1, right, n, str + '(');
    if (left > right) helper(left, right + 1, n, str + ')');
  }

  helper(0, 0, n, '');

  return res;
};
```

https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

解法 1 广度优先

```js
var largestValues = function(root) {
  if (!root) return [];

  let queue = [root],
    res = [];

  while (queue.length !== 0) {
    let size = queue.length,
      max = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < size; i++) {
      let node = queue.shift();
      max = Math.max(node.val, max);

      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }

    res.push(max);
  }

  return res;
};
```

解法 2 深度优先

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
 * @return {number[]}
 */
var largestValues = function(root) {
  if (!root) return [];

  let res = new Map();

  function helper(level, root) {
    // 递归终止条件
    if (!root) {
      return;
    }

    // 处理当前层
    if (root.val !== null) {
      let max =
        res.get(level) !== undefined ? res.get(level) : Number.MIN_SAFE_INTEGER;
      res.set(level, Math.max(max, root.val));
    }

    // 进入下一层
    if (root.left) helper(level + 1, root.left);
    if (root.right) helper(level + 1, root.right);

    // 清理状态
  }

  helper(0, root);

  return Array.from(res.values());
};
```

### 第 11 课

二分查找前期

1. 目标函数的单调性 （单调递增或单调递减）
2. 存在上下界
3. 能够所以访问 （链表就不好实现，但是可以改成跳表）

二分查找模板

```js
let left = 0, right = array.length - 1
while (left <= right) {
  let mid = Math.floor((left + right)/2)
  if (array[mid] === target) {
    break or return result
  } else if (array[mid] < target>) {
    left = mid + 1
  } else {
    right = mid - 1
  }
}
```

https://leetcode-cn.com/problems/sqrtx/submissions/

解法

```js
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  let left = 0,
    right = x,
    mid = null;

  while (right - left > 1e-6) {
    mid = (left + right) / 2;
    if (mid * mid === x) {
      return mid;
    } else if (mid * mid < x) {
      left = mid;
    } else {
      right = mid;
    }
  }

  return Math.floor(right);
};
```

https://leetcode-cn.com/problems/valid-perfect-square/submissions/

解法 1 暴力法

```js
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
  for (let i = 0; i <= num; i++) {
    if (i * i === num) {
      return true;
    } else if (i * i > num) {
      return false;
    }
  }
  return false;
};
```

解法 2 二分法

```js
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
  if (num === 1) return true;

  let left = 1,
    right = num;

  while (left <= right) {
    let mid = Math.floor((right + left) / 2);

    if (mid * mid === num) {
      return true;
    } else if (mid * mid < num) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return false;
};
```
