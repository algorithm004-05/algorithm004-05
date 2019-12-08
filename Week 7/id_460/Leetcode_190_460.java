package week7;

public class Leetcode_190_460 {
    public static void main(String[] args) {
        System.out.println(reverseBitsII(231));
    }
    public static int reverseBits(int n){
        int result = 0;
        for (int i = 0; i <=32 ; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int temp =n>>i;
            // 1.2  取有效位
            temp = temp&i;
            // 2. 然后通过位运算将其放置到反转后的位置.
            temp = temp<<(31-i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= temp;
        }
        return result;
    }
    public static int reverseBitsII(int n){
        int result = 0;
        for (int i = 0; i < 32 ; i++) {
            //每次都处理二进制的最低位, 这样方便进行&操作
            int cur = n&1;
            //直接把二进制的最低位安排到最终位置上
            result = result + (cur<<(31-i));
            //update
            n = n>>1;
        }
        return result;
    }
}
