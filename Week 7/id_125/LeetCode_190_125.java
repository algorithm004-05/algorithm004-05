/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.12.1 10:50
 * @Description:
 */
public class A190 {
    public static void main(String[] args) {
        A190 a190 = new A190();

        int n = 0b00000000010000010000010000001011;

        System.out.println(Integer.toBinaryString(a190.reverseBits(n)));

    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }
}
