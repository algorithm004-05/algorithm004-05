package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_105 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        reverse(root, list);
        return list;
    }

    public void reverse(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        reverse(root.left, list);
        list.add(root.val);
        reverse(root.right, list);
    }

}
