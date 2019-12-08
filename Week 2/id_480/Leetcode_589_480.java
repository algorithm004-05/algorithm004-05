package leetcode.editor.cn;//给定一个 N 叉树，返回其节点值的前序遍历。
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
import java.util.List;

public class Leetcode_589_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_589_480().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
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

    ;

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> integers = new ArrayList<>();
            if (root == null) {
                return integers;
            }
            preOrderTree(root, integers);
            return integers;
        }

        void preOrderTree(Node node, List<Integer> integers) {
            if (node != null) {
                integers.add(node.val);
            }
            if (node != null && node.children != null && node.children.size() > 0) {
                List<Node> children = node.children;
                for (Node n : children) {
                    preOrderTree(n, integers);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}