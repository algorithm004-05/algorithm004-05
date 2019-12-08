package id_105;

public class LeetCode_70_105 {

    public int climbStairs(int n) {
        int[] step = new int[n + 1];
        step[0] = step[1] = 1;
        for(int i = 2; i <= n; i++){
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }

    public int recursion(int n ){
        if(n <= 2){
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    public int dynamic(int n){
        if(n <= 2){
            return n;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for(int i = 3; i <= n ; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
