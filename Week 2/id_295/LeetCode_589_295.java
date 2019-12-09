//给定一个 N 叉树，返回其节点值的前序遍历。
//
//例如，给定一个 3叉树 :
//
//
//
//
//
//
//
//返回其前序遍历: [1,3,5,6,2,4]。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_295 {

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

//    1. 递归，前序遍历，先根结点
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            res.add(root.val);
            for (Node node : root.children) {
                res.addAll(preorder(node));
            }
            return res;
        }
    }
}
