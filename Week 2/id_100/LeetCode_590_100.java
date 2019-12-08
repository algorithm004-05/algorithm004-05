import java.util.*;
/*
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * n叉树的后续遍历
 */
public class LeetCode_590_100 {


    /**
     * 依照前序遍历规则，子节点中左节点先放入栈中，其后结点依次放入栈中
     * 从栈中取出后将其放入值队列中
     * --------------------------
     * 时间复杂度：O(N)
     * 空间复杂度：O(N))
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                ans.add(0, node.val);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return ans;
    }

}