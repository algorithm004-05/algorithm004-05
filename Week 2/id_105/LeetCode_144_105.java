package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_105 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        revert(root, list);
        return list;
    }

    private void revert(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        revert(root.left, list);
        revert(root.right, list);
    }
}
