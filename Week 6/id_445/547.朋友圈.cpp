/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 朋友圈
 */
#include <vector>
#include <iostream>
using namespace std;
// @lc code=start
class Solution {
    int *father;
    
    int findFather(int x){
        while (x!=father[x])
            x=father[x];
        return x;
    }
    void unionSet(int a,int b){
        int fa=findFather(a);
        int fb=findFather(b);
        if(fa!=fb)father[fa]=fb;
        // printF();
    }
    void init( int num){
        father=new int[num];
        
        for (int i = 0; i < num; i++)
        {
         father[i]=i;   
        }
        
    }
public:
    int findCircleNum(vector<vector<int>>& M) {
        init(M.size());
        for (int i = 0; i < M.size(); i++)
        {
            for(int j=i+1;j<M.size();j++){
                if(M[i][j]==1)
                    unionSet(i,j);
            }
        }
        int res=0;
        for (int i = 0; i < M.size(); i++)
        {
            if(i==father[i]) res++;
        }
        return res;
        
        
    }

};
// @lc code=end

int main(){
    vector<vector<int>> m{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}}
;
Solution s;
s.findCircleNum(m);
// s.printF();
}