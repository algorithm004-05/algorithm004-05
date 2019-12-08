package homework.week2;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class LeetCode_429_590 {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        _depth(root, 0, res);
        return res;
    }

    private void _depth(Node node,int depth,List<List<Integer>> res){
        if (node == null){
            return ;
        }

        if (depth+1>res.size()){
            //是新的一层
            res.add(new ArrayList<>());
        }

        res.get(depth).add(node.val);

        for (Node child : node.children) {
            if (child != null){
                _depth(child,depth+1,res);
            }
        }
    }
}
