/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.12.8 11:37
 * @Description:
 */
public class A14 {

    public static void main(String[] args) {
        A14 a14 = new A14();
        String[] strs = new String[]{"flower", "flow", "flight"};

        System.out.println(a14.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }


        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // 判断越界
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}