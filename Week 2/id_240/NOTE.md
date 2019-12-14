### 1、二叉树遍历

* 前序遍历(根-->左-->右)

    ~~~javascript

    function perTreval(root){
        if(!root) return [];
        let res = [];
        res.push(root.val)
        res = res.concat(perTreval(root.left))
        res = res.concat(perTreval(root.right))
        return res;
    }
    ~~~~

* 中序遍历(左-->根-->右)

    ~~~javascript

    function centerTreval(root){
        if(!root) return [];
        let res = [];
        res = res.concat(centerTreval(root.left))
        res.push(root.val)
        res = res.concat(centerTreval(root.right))
        return res;
    }
    ~~~~

* 后续遍历(左-->右-->根)

    ~~~javascript

    function endTreval(root){
        if(!root) return [];
        let res = [];
        res = res.concat(endTreval(root.left))
        res = res.concat(endTreval(root.right))
        res.push(root.val)
        return res;
    }
    ~~~~

### 2、N叉树遍历

* 后续遍历

~~~javascript

    var postorder = function(root) {

    if(!root) return [];
    let res = [];
    for(let i =0;i<root.children.length;i++){
        res = res.concat(postorder(root.children[i]))
    }
    res.push(root.val)
    return res;

}; 
~~~

* 前序遍历

~~~javascript

    var preorder = function(root) {
    if(!root) return [];
    let res = [];
    res.push(root.val)
    for(let i =0;i<root.children.length;i++){
        res = res.concat(preorder(root.children[i]))
    }
    return res;

}; 
~~~

* 前序遍历和中序遍历结果，反向推导二叉树

~~~javascript
var buildTree = function(preorder, inorder) {

    if(preorder.length === 0 && inorder.length === 0){
        return null
    }
    let root = {}
    root.val = preorder[0]
    let rootIndexOrder = inorder.indexOf(root.val)

    let leftTreeInOrder = inorder.slice(0,rootIndexOrder)
    let leftTreePreOrder = preorder.slice(1,leftTreeInOrder.length+1)
    root.left = buildTree(leftTreePreOrder,leftTreeInOrder)

    let rightTreeInOrder = inorder.slice(rootIndexOrder+1)
    let rightTreePreOrder = preorder.slice(rootIndexOrder+1)//右侧在pre和in中的位置一致
    root.right = buildTree(rightTreePreOrder,rightTreeInOrder)

    return root;

}; 
~~~

  

