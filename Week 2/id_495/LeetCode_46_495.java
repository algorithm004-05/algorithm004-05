import java.util.List;
import java.util.ArrayList;

/**
* 给定一个没有重复数字的序列，返回其所有可能的全排列
*/
public class LeetCode_46_495 {
  public static void main(String[] args) {
    System.out.println(permute(new int[]{1,2,3}));
  }

  public static List<List<Integer>> permute(int[] num) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (num.length ==0) return ans;
    List<Integer> l0 = new ArrayList<Integer>();
    l0.add(num[0]);
    ans.add(l0);
    for (int i = 1; i< num.length; ++i){
        List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
        for (int j = 0; j<=i; ++j){
           for (List<Integer> l : ans){
        	   List<Integer> new_l = new ArrayList<Integer>(l);
        	   new_l.add(j,num[i]);
        	   new_ans.add(new_l);
           }
        }
        ans = new_ans;
    }
    return ans;
  }
}
