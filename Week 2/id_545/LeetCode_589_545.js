// 589. N叉树的前序遍历

// 递归
// class Preorder {
//     constructor() {
//         this.arr = []
//     }
//     traversal(root) {
//         if(!root) return []
//         this.arr.push(root.val)
//         for(let i in root.children) {
//             this.traversal(root.children[i])
//         }
//         return this.arr
//     }
// }
// var preorder = function(root) {
//     let p = new Preorder()
//     return p.traversal(root)
// };


// 栈 迭代
var preorder = function(root) {
    if (!root) return []
    let stack = [root]
    let arr = []
    while(stack.length != 0) {
        let curr = stack.pop()
        arr.push(curr.val)
        for(let i = curr.children.length - 1; i >= 0; i--) {
            stack.push(curr.children[i])
        }
    }
    return arr
};