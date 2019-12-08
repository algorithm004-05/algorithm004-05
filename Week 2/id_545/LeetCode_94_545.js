// 94.二叉树的中序遍历

/*******
// 递归
class Inorder {
    constructor() {
        this.arr = []
    }
    traversal(root) {
        if(root) {
            this.traversal(root.left)
            this.arr.push(root.val)
            this.traversal(root.right)
        }
        return this.arr
    }
}

var inorderTraversal = function(root) {
    let inor = new Inorder()
    return inor.traversal(root)
}
*******/

// 迭代 
var inorderTraversal = function(root) {
    let arr = []
    let stack = []
    let curr = root
    while (curr || stack.length != 0) {
        if (curr) {
            stack.push(curr)
            curr = curr.left
        } else {
            curr = stack.pop()
            arr.push(curr.val)
            curr = curr.right
        }
    }
    return arr
};