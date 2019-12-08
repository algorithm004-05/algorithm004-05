import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.27 19:28
 * @Description:
 */
public class A46 {

    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        A46 a46 = new A46();

        int[] nums = new int[]{1, 2, 3};
        System.out.println(a46.permute(nums));
    }

    /**
     * 1、在数组中放入1 [1]
     * 2、在数组中放入2，此时可以在第0个跟第1个位置放入 即： [1,2] [2,1]
     * 3、放入3，此时可以在第一个数组中不同位置放入：[3,1,2] [1,3,2] [1,2,3]
     * 第二个数组依然如此 [3,2,1] [2,3,1] [2,1,3]
     * <p>
     * 时间复杂度？
     *
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num.length == 0) {
            return res;
        }

        List<Integer> l0 = new ArrayList<>();
        l0.add(num[0]);
        res.add(l0);

        for (int i = 1; i < num.length; ++i) {

            // 记录不同的数组
            List<List<Integer>> newList = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> item : res) {

                    // 每当出现一个新的位置，可以复制一份数组，且在相关位置放入
                    List<Integer> cloneItem = new ArrayList<>(item);
                    cloneItem.add(j, num[i]);
                    newList.add(cloneItem);
                }
            }
            res = newList;
        }
        return res;
    }


}
