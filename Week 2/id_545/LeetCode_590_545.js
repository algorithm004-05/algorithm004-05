// 590. N叉树的后序遍历

/*
// 递归
class Post {
    constructor() {
        this.arr = []
    }
    traversal(root) {
        if (!root) return []
        for(let i=0; i< root.children.length; i++) {
            this.traversal(root.children[i])
        }
        this.arr.push(root.val)
        return this.arr
    }
}
var postorder = function(root) {
    let p = new Post()
    return p.traversal(root)
};
*/

//栈 迭代
var postorder = function(root) {
    if (!root) return []
    let stack = [root]
    let arr = []
    while (stack.length != 0) {
        curr = stack.pop()
        arr.push(curr.val)
        for (let i in curr.children) {
            stack.push(curr.children[i])
        }
    }
    arr.reverse()
    return arr
};