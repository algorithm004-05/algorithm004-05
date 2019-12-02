package com.neutorn.algorithm;

public class LeetCode_231 {
    /**
     * 第一步:仔细审题,给定一个整数，编写一个函数来判断它是否是2的幂次方
     * 第二步:采用位运算进行处理
     * 第三步:厉害的处理方式想不到,很多题目都是必须看题解,然后去归纳总结,也许一辈子都想不到的方案
     * 第四步:进行各种测试用例测试
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
