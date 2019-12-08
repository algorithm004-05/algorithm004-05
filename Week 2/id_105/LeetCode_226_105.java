package id_105;

public class LeetCode_226_105 {

    public TreeNode invertTree(TreeNode root) {

        if(root != null && (root.left != null || root.right != null)){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }

}



