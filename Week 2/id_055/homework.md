# 课后作业

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

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

解法 1 递归 找出 path

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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  function findPath(root, target, paths) {
    if (!root) {
      return false;
    }

    paths.push(root);

    if (root.val == target.val) {
      return true;
    }

    if (
      findPath(root.left, target, paths) ||
      findPath(root.right, target, paths)
    ) {
      return true;
    }

    paths.pop();
  }

  const pPaths = [],
    qPaths = [];

  findPath(root, p, pPaths);
  findPath(root, q, qPaths);

  let i = 0;
  for (; i < pPaths.length; i++) {
    if (pPaths[i] !== qPaths[i]) {
      break;
    }
  }

  return pPaths[i - 1];
};
```

https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

https://leetcode-cn.com/problems/combinations/

```js
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let ans = [];

  function helper(index, n, k, list) {
    // 终止条件
    if (index === k) {
      ans.push(list);
      return;
    }

    for (let i = 1; i <= n; i++) {
      // 后面的元素必须大于之前的元素
      if (list.every(item => item < i)) {
        list.push(i);
        helper(index + 1, n, k, [...list]);
        list.pop();
      }
    }
  }

  helper(0, n, k, []);

  return ans;
};
```

https://leetcode-cn.com/problems/permutations/

```js
//**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {

    let ans = []

    function helper(index, nums, list) {
        // 递归终止条件
        if (index === nums.length) {
            ans.push(list)
            return
        }

        for (let i=0; i<nums.length; i++) {
            // 排除重复元素
            if (list.indexOf(nums[i]) === -1) {
                list.push(nums[i])
                // 下探
                helper(index+1, nums, [...list])
                // 恢复
                list.pop()
            }
        }
    }

    helper(0, nums, [])

    return ans
};
```

https://leetcode-cn.com/problems/permutations-ii/

```js
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  // 先排序
  nums.sort((a, b) => a - b);

  let ans = [];

  function helper(index, nums, list, visited) {
    if (index === nums.length) {
      ans.push(list);
      return;
    }

    for (let i = 0; i < nums.length; i++) {
      // visited 保证每个 i 只用一次
      if (visited[i]) continue;
      // 相邻重复元素，只用 1 次
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
      visited[i] = true;
      list.push(nums[i]);
      helper(index + 1, nums, [...list], visited);
      visited[i] = false;
      list.pop();
    }
  }

  helper(0, nums, [], new Array(nums.length).fill(false));

  return ans;
};
```

## 第 8 课
https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）


解法1 排序
```js
var majorityElement = function(nums) {
    nums.sort((a, b) => a-b)
    return nums[Math.floor(nums.length/2)]
};
```

解法2 HashMap
```
var majorityElement = function(nums) {
    
    if (nums.length === 1) {
        return nums[0]
    }
    
    let map = new Map()
    
    for (let i=0; i<nums.length; i++) {
        if (map.has(nums[i])) {
            let c = map.get(nums[i])
            if (c+1 > nums.length/2) {
                return nums[i]
            }
            map.set(nums[i], c+1)
        } else {
            map.set(nums[i], 1)
        }
    }
};
```

解法3 分治
```js
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    
    function countInRange(nums, num, leftIndex, rightIndex) {
        let count = 0;
        for (let i = leftIndex; i <= rightIndex; i++) {
            if (nums[i] === num) {
                count++;
            }
        }
        return count;
    }

    
    function helper(nums, leftIndex, rightIndex) {
        if (leftIndex === rightIndex) {
            return nums[leftIndex]
        }
        
        let mid = Math.floor((rightIndex - leftIndex)/2 + leftIndex)
        
        let left = helper(nums, leftIndex, mid);
        let right = helper(nums, mid+1, rightIndex);

        // if the two halves agree on the majority element, return it.
        if (left === right) {
            return left;
        }

        // otherwise, count each element
        let leftCount = countInRange(nums, left, leftIndex, mid)
        let rightCount = countInRange(nums, right, mid+1, rightIndex)
        
        return leftCount > rightCount ? left : right;

    }
    
    return helper(nums, 0, nums.length-1)
};
```

https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

解法1
```js
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    
    if(digits === "") return []
    
    let map = new Map()
    
    map.set('2', 'abc')
    map.set('3', 'def')
    map.set('4', 'ghi')
    map.set('5', 'jkl')
    map.set('6', 'mno')
    map.set('7', 'pqrs')
    map.set('8', 'tuv')
    map.set('9', 'wxyz')
    
    
    let res = []
    
    function helper(index, digits, str, visited) {
        if (index === digits.length) {
           res.push(str) 
           return  
        }
        
        for (let i=0; i<digits.length; i++) {
            
            let letters = map.get(digits[i])
            
            for (let j=0; j<letters.length; j++) {
                 if (visited[i] || visited[i+1] ) continue
                 visited[i] = true    
                 str += letters[j]
                 helper(index+1, digits, str, visited)
                 visited[i] = false    
                 str = str.substr(0, str.length-1) 
            }
        }
    }
    
    helper(0, digits, '', [])
    
    return res
};
```

解法2
```js
var letterCombinations = function(digits) {
    
    if(digits === "") return []
    
    let map = new Map()
    
    map.set('2', 'abc')
    map.set('3', 'def')
    map.set('4', 'ghi')
    map.set('5', 'jkl')
    map.set('6', 'mno')
    map.set('7', 'pqrs')
    map.set('8', 'tuv')
    map.set('9', 'wxyz')
    
    
    let res = []
    
    function helper(index, digits, str) {
        if (index === digits.length) {
           res.push(str) 
           return  
        }
            
        let letters = map.get(digits[index])

        for (let j=0; j<letters.length; j++) {
             str += letters[j]
             helper(index+1, digits, str)
             str = str.substr(0, str.length-1) 
        }
        
    }
    
    helper(0, digits, '')
    
    return res
};
```

https://leetcode-cn.com/problems/n-queens/

```js
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let res = [], cols = new Set(), pie = new Set(), na = new Set()
    
    function helper(row /*level*/, n, curr_state) {
        if (row >= n) {
            res.push(curr_state)
            return 
        }
        
        for (let col=0; col<n; col++) {
            if (cols.has(col) || pie.has(row + col) || na.has(row-col)) {
                continue
            }
            
            cols.add(col)
            pie.add(row + col)
            na.add(row-col)
            
            // 注意复制 curr_state
            helper(row+1, n, [...curr_state, col])
            
            cols.delete(col)
            pie.delete(row + col)
            na.delete(row-col)
        }
    }
    
    helper(0, n, [])
    
    
    return generate(res)
};

function generate(res) {
    
    let temp = []
    
    for (let i=0; i<res.length; i++) {
        let len = res[i].length
        temp[i] = []
        for (let j=0; j<len; j++) {
             temp[i].push(Array(len).fill('.').fill('Q', res[i][j], res[i][j]+1).join(''))
        }
    }
    
    return temp
}
```