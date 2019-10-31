

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
*给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *          1
 *      *   *     *
 *   3      2     4
 *  * *
 *5     6
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class LeetCode_590_510 {
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

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root,List<Integer> list){
        if(null == root){
            return;
        }
        List<Node> _children = root.children;
        if(null !=_children && 0 <= _children.size()){
            for (int i = 0; i < _children.size(); i++) {
                helper(_children.get(i), list);
            }
        }
        list.add(root.val);
    }

    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        if(null == root){
            return linkedList;
        }
        Node node = root;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()){
            node = stack.pop();
            List<Node> _children = node.children;
            linkedList.addFirst(node.val);
            if(null !=_children && 0 <= _children.size()){
                // 需要从右向左   先入后出 
                for (int i = 0; i < _children.size(); i++) {
                    stack.push(_children.get(i));
                }
            }
        }
        return linkedList;
    }
}
