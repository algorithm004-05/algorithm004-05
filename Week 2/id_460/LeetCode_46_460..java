package week2.Homework.Question46Permute;

import java.util.*;

public class Permute {
    private  int numsLength;
    private Stack<Integer> path;
    private Integer[] path2;
    private List<List<Integer>> result;
    private boolean[] state;

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute p = new Permute();
        List<List<Integer>> permute1 = p.permute(nums);
        for (int i =0;i<permute1.size();i++){

        }
    }

    public List<List<Integer>> permute(int [] nums){
        numsLength = nums.length;
        if (numsLength<=0){
            return result;
        }
        state = new boolean[numsLength];
        path = new Stack<>();
        path2 = new Integer[numsLength];
        result = new LinkedList<>();

        dfs(nums,0);
        dfsII(nums,0);

        return result;
    }
    /**
     *第1个数 可以有n种放置方式, 分别为放在第0个位置, 第1个位置, 第2个位置...第n个位置
     * 当第1个数放置完成后, 第2个数可以有2种放置方式
     * 当第1个数和第2个数都放置完成后, 第3个数只有1种放置方式.
     */
    private void dfsII(int[] nums, int pos) {
        if (pos == numsLength){
            result.add(new ArrayList<>(Arrays.asList(path2)));
            return;
        }
        for (int i=0;i<numsLength;i++){
            if(!state[i]){
                //保存现场
                state[i] = true;

                path2[i] = nums[pos];
                dfsII(nums,pos+1);

                //恢复现场
                state[i]=false;
            }
        }
    }
    /**
     * 第 0个位置可以放n个数，
     * 当第0个位置放好以后，第1个位置,剩余n-1个数可以放置；
     * 当第0个和第1个位置放置好以后，第2个位置，有n-2个数可以放置。
     */
    private void dfs(int[] nums, int pos) {
        if(pos==numsLength){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<numsLength;i++){
            if (!state[i]){
                state[i] = true;
                path.push(nums[i]);

                dfs(nums,pos+1);

                path.pop();
                state[i]=false;
            }
        }
    }
}
