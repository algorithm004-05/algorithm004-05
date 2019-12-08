package id_105;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_46_105 {


    private List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        revertList( nums, new Stack<Integer>());
        return list;

    }

    public void revertList( int[] nums, Stack<Integer> stack){
        if(stack.size() == nums.length){
            list.add(new ArrayList<Integer>(stack));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(stack.contains(nums[i])){
                continue;
            }
            stack.add(nums[i]);
            revertList(nums, stack);
            stack.pop();
        }
    }
}
