package lesson.week.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by liangwj20 on 2019/10/27 17:31
 * Description: 给定一个二叉树，返回它的中序 遍历。。
 */
public class LeetCode_94_320 {

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        leftNode.left = null;
        System.out.println(inorderTraversal(rootNode));
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(Objects.isNull(root)) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        recursive(res, root);
        return res;
    }

    private static void recursive(List<Integer> res, TreeNode root) {
        if(!Objects.isNull(root.left)) {
            recursive(res, root.left);
        }
        res.add(root.val);
        if(!Objects.isNull(root.right)) {
            recursive(res, root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
