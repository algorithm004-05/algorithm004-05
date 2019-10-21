# NOTE

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