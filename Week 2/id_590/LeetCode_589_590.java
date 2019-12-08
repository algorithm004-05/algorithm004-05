package homework.week2;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
public class LeetCode_589_590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        if (root.children==null){
            result.add(root.val);
            return result;
        }

        result.add(root.val);

        for (Node child : root.children) {
            result.addAll(preorder(child));
        }

        return result;
    }
}
