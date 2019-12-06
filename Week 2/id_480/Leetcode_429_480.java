package leetcode.editor.cn;  //给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_429_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_429_480().new Solution();
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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            printTreeInLevel(result, root);
            return result;
        }

        private void printTreeInLevel(List<List<Integer>> result, Node node) {
            if (node == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int count = queue.size();
                //开始遍历
                //每一层创建一个list
                List<Integer> levelIntegers = new ArrayList<>();
                while (count-- > 0) {
                    Node curr = queue.poll();
                    levelIntegers.add(curr.val);
                    if (curr.children != null) {
                        for (Node n : curr.children) {
                            queue.add(n);
                        }
                    }
                }
                result.add(levelIntegers);
            }

        }
    }

    /**
     * 使用递归
     */
    class Solution2 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            printTreeInLevel(root, 0, res);
            return res;
        }

        private void printTreeInLevel(Node node, int depth, List<List<Integer>> result) {
            if (node == null) {
                return;
            }
            if (depth + 1 > result.size()) {
                //需要新增一层
                result.add(new ArrayList<Integer>());
            }
            result.get(depth).add(node.val);
            //处理子节点
            if (node.children != null) {
                List<Node> children = node.children;
                for (Node n : children) {
                    printTreeInLevel(n, depth + 1, result);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}