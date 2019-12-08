package id_105;

public class LeetCode_338_105 {


    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = count(i);
        }

        return result;
    }

    private int count2(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) != 0) {
                count++;
            }
            i = i >> 1;
        }
        return count;
    }

    private int count(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
