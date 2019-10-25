// 144. 二叉树的前序遍历

/*
// 迭代法
var preorderTraversal = function(root) {
    let arr = []
    let stack = []
    let curr = root
    while (curr || stack.length != 0) {
        if (curr) {
            arr.push(curr.val)
            stack.push(curr)
            curr = curr.left
        } else {
            curr = stack.pop()
            curr = curr.right
        }
    }
    return arr
};
*/

// 递归
class Preorder {
    constructor() {
        this.arr = []
    }
    traversal (root) {
        if (root) {
            this.arr.push(root.val)
            this.traversal(root.left)
            this.traversal(root.right)
        }
        return this.arr
    }
}
var preorderTraversal = function(root) {
    let preor = new Preorder()
    return preor.traversal(root)
}