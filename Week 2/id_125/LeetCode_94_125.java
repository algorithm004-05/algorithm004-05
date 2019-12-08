import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.24 23:21
 * @Description:
 */
public class A94 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

//        System.out.println(inorderTraversal(treeNode));
        System.out.println(inorderTraversal2(treeNode));

    }

    /**
     * 首先明白，这是中序遍历，所以遍历顺序是：
     * 左中右，所以添加元素的顺序需要注意
     * 时间复杂度跟元素个数有关：O(n)
     *
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private static void helper(TreeNode root, List<Integer> res) {

        if (root != null) {

            // 左
            if (root.left != null) {
                // 如果左边依然存在子节点，那么继续递归遍历
                helper(root.left, res);
            }

            // 中
            res.add(root.val);

            // 右
            if (root.right != null) {
                // 如果右边依然存在子节点，那么继续递归遍历
                helper(root.right, res);
            }
        }

    }


    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // 只要存在左节点，那么就一直压栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            /*
             * 当没有左节点的时候，上一个节点就是最左值，
             * 那么pop出来，取值， 并且，对右边进行遍历
             */
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


}
