# NOTE
第5课

https://leetcode-cn.com/problems/valid-anagram/description/

解法1 排序
```js
var isAnagram = function(s, t) {

    if (typeof s === 'undefined' || typeof t === 'undefined') return false

    if (s.length !== t.length) return false

    return s.split('').sort().join() === t.split('').sort().join()
};
```

解法2 HashMap
```js
var isAnagram = function(s, t) {

    if (typeof s === 'undefined' || typeof t === 'undefined') return false
    
    if (s.length !== t.length) return false
    
    const map = new Map()
    
    for (let i in s) {
        let key = map.get(s[i])
        key !== undefined ? map.set(s[i], ++key) :  map.set(s[i], 1)
    }
    
    for (let i in t) {
        let key = map.get(t[i])
        if (key !== undefined) {
            map.set(t[i], --key) 
        } else {
            return false
        }
    }

    
    for (let value of map.values()) {
       if (value !== 0) {
           return false
       }
    }
    
    return true
};
```

解法3 自建 HashMap

```js
var isAnagram = function(s, t) {
    
    if (typeof s === 'undefined' || typeof t === 'undefined') return false
    
    if (s.length !== t.length) return false
    
    let count = s => {
        let map = {}
        s.forEach(i => {
            let hashCode = i.charCodeAt() - 'a'.charCodeAt()
            map[hashCode] !== undefined ? map[hashCode] += 1 : map[hashCode] = 1
        })
        
        return map
    }
    
    let sM = count(s.split(''))
    let tM = count(t.split(''))
    
    function compareMap(sM, tM) {
       for (let key in sM) {
           if (sM[key] !== tM[key]) {
               return false
           } 
       }
       return true
    }
    
    return compareMap(sM, tM)
};
```


https://leetcode-cn.com/problems/group-anagrams/


```js
var groupAnagrams = function(strs) {
    let map = new Map()
    
    function hash(key) {
        let m = Array.from({length: 26}).fill(0)
        
        for (let s of key) {
           let code = s.charCodeAt() - 'a'.charCodeAt()
           m[code] += 1
        }
        
        return m.join('#')
    }
    
    for (let i=0; i<strs.length; i++) {
        let hashCode = hash(strs[i])
        let value = map.get(hashCode)
        value !== undefined ? map.set(hashCode, [...value, strs[i]]) : map.set(hashCode, [strs[i]])
    }
    
    return Array.from(map.values())
};
```

https://leetcode-cn.com/problems/two-sum/description/

```js
var twoSum = function(nums, target) {
    let map = new Map()
    for (let i=0; i<nums.length; i++) {
        map.set(target - nums[i], i)
    }
    
    for (let j=0; j<nums.length; j++) {
        let temp = map.get(nums[j])
        if (temp !== undefined && temp !== j) {
            return [j, temp]
        }
    }
};
```


第6课
树，二叉树，二叉搜索树  

二叉树中序遍历

https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

解法1 递归
```js
var inorderTraversal = function(root) {
    let res = []
    function traversal(node) {
        if (!node) return
        if (node.left) traversal(node.left)
        if (node.val) res.push(node.val)
        if (node.right) traversal(node.right)
    }
    
    traversal(root)
    
    return res
};
```

解法2 栈
```js
var inorderTraversal = function(root) {
    let res = [], stack = []
    
    let currNode = root
    
    while (currNode || stack.length !== 0) {
        while (currNode) {
            stack.push(currNode)
            currNode = currNode.left
        }
        
        currNode = stack.pop()
        res.push(currNode.val)
        currNode = currNode.right
    } 
    
    return res
};
```

https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

解法1
递归
```js
var preorderTraversal = function(root) {
    let res = []
    function traversal(node) {
        if (!node) return
        res.push(node.val)
        if (node.left) traversal(node.left)
        if (node.right) traversal(node.right)
    }
    
    traversal(root)
    
    return res
};
```

解法2
栈
```js
var inorderTraversal = function(root) {
    let res = [], stack = []
    
    let currNode = root
    
    while (currNode || stack.length !== 0) {
        while (currNode) {
            stack.push(currNode)
            currNode = currNode.left
        }
        
        currNode = stack.pop()
        res.push(currNode.val)
        currNode = currNode.right
    } 
    
    return res
};
```

https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

解法1 递归

```js
var postorder = function(root) {
    let res = []
    function helper(node) {
        
        if (!node) return
        
        let children = node.children
        
        for (let i=0; i<children.length; i++) {
           helper(children[i]) 
        }
        
        res.push(node.val)
    }
    
    helper(root)
    
    return res
};
```

解法2 stack

```js
var postorder = function(root) {
    let res = [], stack = []
    
    stack.push(root)
    
    while (root && stack.length !== 0) {
        root = stack.pop() 
        res.push(root.val)
        stack.push()
    }
    
    return res
};
```

https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

解法1

```js
var preorder = function(root) {
   let res = []
   
   function helper(node) {
       if (node) res.push(node.val)
       let children = node.children
       for (let i=0; i<children.length; i++) {
           helper(children[i])
       }
   }
    
    helper(root)
    
    return res
};
```

解法2
```js
var preorder = function(root) {
   let res = [], stack = [root]
    
   while (root && stack.length !== 0) {
        root = stack.pop()
        res.push(root.val)
       
        let children = root.children
        
        for (let i = children.length -1; i>=0; i--) {
            stack.push(children[i])
        }
       
   }
    
   return res
};
```

https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal

解法
```js
var levelOrder = function(root) {
    
    if(!root) return []
    
    let levels = [], queue = [root]
    
    while (queue.length !== 0) {
        let levelSize = queue.length
        
        const currLevel = []
       
        for (let i=0; i<levelSize; i++) {
           
           const node = queue.shift() 
           
           currLevel.push(node.val)
           
           let children = node.children
            
           queue.push(...children)
            
       }
        
        levels.push(currLevel)
    }
    
    return levels
    
};
```