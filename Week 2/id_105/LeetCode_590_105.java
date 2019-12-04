package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_105 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        revert(root, list);
        return list;
    }

    private void revert(Node root, List<Integer> list){
        if(root == null){
            return;
        }

        for(Node node : root.children){
            revert(node, list);
        }
        list.add(root.val);

    }


}
