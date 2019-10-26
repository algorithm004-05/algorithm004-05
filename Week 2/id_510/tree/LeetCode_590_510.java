

import java.util.List;

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
        return null;
    }
}
