import java.util.List;
import java.util.ArrayList;

/**
* 组合
*/
public class LeetCode_77_495 {

  public static void main(String[] args) {
    System.out.println(combine(4,2));
  }

  public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }
}
