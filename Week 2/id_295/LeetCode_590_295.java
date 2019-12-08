//给定一个 N 叉树，返回其节点值的后序遍历。
//
//例如，给定一个 3叉树 :
//
// 
//
//
//
// 
//
//返回其后序遍历: [5,6,3,2,4,1].
//
// 
//
//说明: 递归法很简单，你可以使用迭代法完成此题吗?
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_295 {

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

    //    1. 递归，后序遍历，后根结点
    class Solution {

        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            for (Node node : root.children) {
                res.addAll(postorder(node));
            }
            res.add(root.val);
            return res;
        }
    }
}
