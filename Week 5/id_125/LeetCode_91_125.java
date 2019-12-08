/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.16 16:29
 * @Description:
 */
public class A91 {
    public static void main(String[] args) {
        A91 a91 = new A91();
        String s = "110";
        System.out.println(a91.numDecodings(s));
    }

    /**
     * 类似于爬楼梯，但是是存在约束条件的爬楼梯。分情况分析：
     * 1、最后一个数字是0
     * 1.如果前一个数字是1或者2，那么0只能跟前一个数字组合，所以不会增加情况
     * 2.如果前一个数字非1/2，那么不可能存在解析通过的情况，直接放回0
     * 2、最后一个数字不是0
     * 如果前一个数字是：
     * 1.是1，那么可以直接转换为爬楼梯。dp[i] = dp[i-1]+dp[i-2]
     * 2.是2，且最后一位是1-6之间（0在上面的情况，这里不用讨论了）。那么跟1的情况一致
     * 除开上述两种情况，其他的情况都不会额外增加解码方法总数。    dp[i] = dp[i-1]
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        // 跟爬楼梯一样定义即可。但是条件存在一定限制，所以初始化前两个值，且数组长度+1
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 1; i < chars.length; i++) {

            if (chars[i] == '0') {
                if (chars[i - 1] != '1' && chars[i - 1] != '2') {
                    return 0;
                }
                dp[i + 1] = dp[i - 1];
            } else {
                if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }

            }
        }
        return dp[dp.length - 1];
    }
}