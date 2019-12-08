package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_105 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        revert(root,0, list);
        return list;
    }

    private void revert(Node root,int n, List<List<Integer>> list){
        if(root == null){
            return;
        }
        List<Integer> childrenList = null;
        if(list.size() <= n){
            childrenList = new ArrayList<Integer>();
            list.add(childrenList);
        }else{
            childrenList = list.get(n);
        }

        childrenList.add(root.val);
        for(Node node : root.children){
            revert(node,n + 1,  list);
        }
    }
}
