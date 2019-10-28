package id_105;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_77_105 {


    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {

        revert(1, n, k,new Stack<Integer>());
        return list;
    }


    public void revert(int start, int n, int k, Stack<Integer> stack){
        if(stack.size() == k){
            this.list.add(new ArrayList<Integer>(stack));
            return;
        }

        for(int i = start; i <= n; i++){
            stack.add(i);
            revert(i + 1, n, k, stack);
            stack.pop();
        }
    }
}
