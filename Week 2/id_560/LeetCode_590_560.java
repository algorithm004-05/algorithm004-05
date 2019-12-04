//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import JiKe.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    //递归
    public List<Integer> postorder(Node root) {
        List<Integer> lists = new ArrayList<>();
        helper(lists,root);
        return lists;
    }
    private void helper(List<Integer> lists,Node root){
        if (root != null) {
            if (root.children != null) {
                for (Node node : root.children) {
                    if (node.children != null) {
                        helper(lists,node);
                    }
                }
            }
            lists.add(root.val);
        }
    }
    //迭代
    public List<Integer> postorder(Node root) {
        List<Integer> lists = new ArrayList<>();
        Stack<App.Node> stack = new Stack<>();
        App.Node currentNode = root;
        stack.push(currentNode);
        //弄一个前节点 出栈的时候判断一下这个节点的children已经被lists加好了，否则无限循环递归。每一次回到有children的节点时栈不会出，而会再push
        App.Node pre = null;
        while (!stack.isEmpty()) {
            App.Node curr = stack.peek();
            if(curr.children.size() != 0 && !curr.children.contains(pre)) {
                for(int i = curr.children.size() -1; i>=0;i--) {
                    stack.push(curr.children.get(i));
                }
            }else {
                lists.add(curr.val);
                pre = stack.pop();
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
