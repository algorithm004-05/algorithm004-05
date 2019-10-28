/**
 * 
 * n叉树的前序遍历
 */
public class LeetCode_598_100 {

    /**
     * 方式一：递归
     * 使用前序遍历
     * -------------------
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            helper(child, ans);
        }
    }


    /**
     * 方式二：使用迭代
     * 使用栈模拟递归操作
     * -------------------
     * 时间复杂度：
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                ans.add(node.val);
                List<Node> children = node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return ans;
    }

}
