import java.util.Arrays;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.3 12:38
 * @Description:
 */
public class A455 {
    public static void main(String[] args) {
        A455 a455 = new A455();
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};

        System.out.println(a455.findContentChildren(g, s));
    }

    /**
     * 1、明确题目：一个小朋友最多只能拥有一块饼干
     * 尽量以胃口小的为第一分配目标。
     * 所以排序后，从0开始for循环
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int assignment = 0;
        int j = 0;

        for (int i = 0; i < g.length; i++) {

            while (j < s.length) {
                if (s[j] >= g[i]) {
                    assignment++;
                    j++;
                    break;
                }
                j++;
            }

            if (j > s.length) {
                break;
            }

        }

        return assignment;
    }
}
