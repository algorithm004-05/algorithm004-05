import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
    //     //方法一，recursion
    //     List<Integer> result = new LinkedList<>();
    //     if (root == null) return result;
    //     postHelper(root, result);
    //     return result;
    // }

    // public void postHelper(Node root, List<Integer> result) {
    //     //terminator
    //     if (root == null) return;
    //     //process current logic
    //     int currSize = root.children.size();
    //     for (int i = 0; i < currSize; i++) {
    //         postHelper(root.children.get(i), result);
    //     }
    //     result.add(root.val);

        //方法二，iteration
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
                root = stack.pop();            
                result.addFirst(root.val);
                for (Node node : root.children) {
                    stack.add(node);
                }
        }
        return result;
    }
}
// @lc code=end

