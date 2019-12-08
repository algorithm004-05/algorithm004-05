//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;

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
    public List<Integer> preorder(Node root) {
        List<Integer> lists = new ArrayList<>();
        helper(lists,root);
        return lists;
    }
    private void helper(List<Integer> lists,Node node) {
        if (node != null) {
            lists.add(node.val);
            if (node.children.size() != 0) {
                for(Node _node : node.children) {
                    helper(lists,_node);
                }
            }
        }
    }
    //迭代
    public List<Integer> preorder(Node root) {
        List<Integer> lists = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node curr = root;
        stack.push(curr);
        while(curr != null) {
            curr = stack.peek();
            if(curr.children.size() != 0 && !curr.children.contains(pre)) {
                for (int i = curr.children.size() - 1; i>= 0; i--) {
                    lists.add(curr.children.get(i));
                }
                lists.add(curr.val);
            } else {
                lists.contains(curr.val) ? : lists.add(curr.val);
                stack.pop();
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
