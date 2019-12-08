//递归解法

class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return doPow(x,N);
    }
    
    public double doPow(double x,long n){
        if(n==0){
            return 1.0;
        }
        double res=doPow(x,n/2);
        return (n % 2)==1 ? res*res*x : res*res;
    }
}
 

 //非递归解法

    def myPow(x, n):
        if n<0:
            x=1/x
            n=-n
        pow=1
        while n:
            if n & 1:
                pow *=x
            x *= x
            n >>=1
        return pow