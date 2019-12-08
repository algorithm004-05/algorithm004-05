package leetcode.jacf.tech;

import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    // Definition for a Node.
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


    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(Node root, List<Integer> result) {
            if (root != null) {
                result.add(root.val);
                for (Node n : root.children) {
                    helper(n, result);
                }
            }
        }
    }
}
