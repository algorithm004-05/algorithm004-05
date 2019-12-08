public class A191 {

    public static void main(String[] args) {
        A191 a191 = new A191();

        int n = 0b00000000010000010000010000001011;
//        System.out.println(Integer.toBinaryString(n));
        System.out.println(a191.hammingWeight1(n));
        System.out.println(a191.hammingWeight2(n));
    }


    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public int hammingWeight2(int n) {
        int bit = 0;
        int mark = 1;

        // 第一次是1 第二次是10 第三次是100。逐次比较更高位
        for (int i = 0; i < 32; i++) {
            if ((mark & n) != 0) {
                bit++;
            }
            mark <<= 1;
        }

        return bit;
    }
}
