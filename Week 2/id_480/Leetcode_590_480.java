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

public class Leetcode_590_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_590_480().new Solution();
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
        public List<Integer> postorder(Node root) {
            List<Integer> integers = new ArrayList<>();
            if(root == null){
                return integers;
            }
            postOrderTree(root,integers);
            return integers;
        }

        void postOrderTree(Node node, List<Integer> integers) {
            if (node == null) {
                return;
            }
            List<Node> children = node.children;
            if (children != null) {
                //遍历子树
                for (Node n : children) {
                    postOrderTree(n, integers);
                }
            }
            integers.add(node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}