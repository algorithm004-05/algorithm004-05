/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.12.1 10:48
 * @Description:
 */
public class A231 {
    public static void main(String[] args) {
        A231 a231 = new A231();

        int n = 9;
        System.out.println(a231.isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
