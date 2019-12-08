package id_105;

public class LeetCode_190_105 {


    public int reverseBits(int n) {
        int t = 0;
        for(int i = 0; i < 32; i++) {
            t = (t << 1) + (n & 1);
            n = n >> 1;
        }
        return t;
    }


}
