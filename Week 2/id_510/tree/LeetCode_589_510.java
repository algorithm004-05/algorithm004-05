

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
*给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *          1
 *      *   *     *
 *   3      2     4
 *  * *
 *5     6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class LeetCode_589_510 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root,List<Integer> list){
        if(null == root){
            return;
        }
        list.add(root.val);
        List<Node> _children = root.children;
        if(null ==_children || 0 == _children.size()){
            return;
        }
        for (int i = 0; i < _children.size(); i++) {
            helper(_children.get(i), list);
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        Node node = root;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()){
            node = stack.pop();
            list.add(node.val);
            // 从左向右遍历 所以反向入栈
            for (int i = node.children.size()-1; i >=0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
