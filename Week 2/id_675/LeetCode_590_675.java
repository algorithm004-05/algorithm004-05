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

    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {

        List<Integer> re = new ArrayList<>();

        loopPrint(root, re);

        return re;
    }

    private void loopPrint(Node node,List re){
        if(node.children.size() == 0) return;
        re.add(node.val);
        for (Node node1 : node.children){
            loopPrint(node1,re);
        }
    }

    /**
    public List<Integer> postorder(Node root) {
        List<Integer> re = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null ) return re;

        stack.push(root);
        Node pre = null;
        while (!stack.empty()){
            node cur =  stack.pop();
            re.add(cur.val);

            int size = cur.children.size();
            for (int i = size-1;i>=0;i--){
                    stack.push(cur.children.get(i));
                }
            }

        return re;
    }
      */
    }

//leetcode submit region end(Prohibit modification and deletion)
