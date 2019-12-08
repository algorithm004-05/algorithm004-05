/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 */

// @lc code=start
//class Solution {
//public:
//    int climbStairs(int n) {
//        if (n <= 2) return n;
//        int step1 = 1, step2 = 2, step3 = 0;
//        for (int i = 3 ; i < n + 1 ; i++){
//            step3 = step1 + step2;
//            step1 = step2;
//            step2 = step3;
//        }
//        return step3;
//    }
//};
/********************************************************************************/
//带缓存的递归，beat100%
/********************************************************************************/
//class Solution
//{
//public:
//    int climbStairs(int n)
//    {
//        vector<int> memo(n, 0);
//
//        return climbStairs(0, n,  memo);
//    }
//
//private:
//    int climbStairs(int i, int n, vector<int> &memo)
////超出内存限制 没有用引用作为参数，造成多次的拷贝；
//  //  int climbStairs(int i, int n, vector<int> memo)
//    {
//        if (n <= 2 ) return n;
//        if (i == n - 1)
//            return 1;
//        if (i == n - 2)
//            return 2;
//        if (memo[i] > 0)
//            return memo[i];
//        memo[i] = climbStairs(i + 1, n , memo) + climbStairs(i + 2, n, memo);
//        return memo[i];
//    }
//};
//通项公式
//class Solution
//{
//public:
//    int climbStairs(int n)
//    {
//        n++;
//        double sqrt5 = pow(5, 0.5);
//        double res =  1/sqrt5*(pow((1+sqrt5)/2,n) - pow((1-sqrt5)/2,n));
//        return (int)(res);
//    }
//};
class Solution
{
public:
    int climbStairs(int n)
    {
        n++;
        double sqrt5 = pow(5, 0.5);
        double res =  1/sqrt5*(pow((1+sqrt5)/2,n) - pow((1-sqrt5)/2,n));
        return (int)(res);
    }
//};
/*******************************************************************************/
//time complexity is log(n). Use matrix maltipulication to avoid the around operation and the time complexity of pow is log(n);
//only faster than 69% cpp user?
/*******************************************************************************/
class Solution
{
public:
    int climbStairs(int n)
    {
        if( n < 2) return n;
        vector<vector<int>> feb = {{0, 1}, {1, 1}};
        vector<vector<int>> ini = {{0, 1}, {0, 0}};
        return matrixMulti(ini, matrixPow(n, feb))[0][1];
    }
 // 使用引用形参时，如果不改变实参，因该统一定为为const 引用，以避免对函数使用的限制：见C++ primer 中文版 第四版 第204页
    vector<vector<int>> matrixMulti(const vector<vector<int>> &x, const vector<vector<int>> &y){
        vector<vector<int>> a = {{0,  0}, {0, 0}};
        for (int i = 0 ; i < 2 ; i++ ){
            for (int j = 0; j < 2; j++){
                a[i][j] = x[i][0]*y[0][j] + x[i][1]*y[1][j]; 
            }
        }
        return a;
    }
private:
     vector<vector<int>> matrixPow(int n, const vector<vector<int>> &x){
        vector<vector<int>> v = x;
        vector<vector<int>> r = {{1,0},{0,1}};
        if(n == 0){
           return r;
        }
        while(n){
            if (n % 2 == 0){
                v = matrixMulti(v, v);
                n = n / 2;
            }
            else{
                r = matrixMulti(r, v);
                n--;
            }
        }
        return r;
    }
};


// @lc code=end

