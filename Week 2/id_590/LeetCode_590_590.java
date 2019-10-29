package homework.week2;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
public class LeetCode_590_590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        if (root.children==null){
            result.add(root.val);
            return result;
        }

        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        result.add(root.val);

        return result;
    }
}
