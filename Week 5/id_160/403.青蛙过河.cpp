/*
 * @lc app=leetcode.cn id=403 lang=cpp
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
public:
    bool jump(vector<int>&s, int pos,int n, int k, vector<vector<int>>&p){
        if(pos>=n)return(true);
        if(s[pos+1]-s[pos]>k+1)return(false);
        bool res=false;
        int i,j,fl;
        for(i=1;i+pos<=n && s[pos+i]-s[pos]<=k+1;i++){
            if(s[pos+i]-s[pos]>=k-1){
                if(p[pos+i].size()){
                    fl=0;
                    for(j=0;j<p[pos+i].size();j++){
                        if(s[pos+i]-s[pos]-p[pos+i][j]==0){ fl=1; break;}
                    }
                    if(fl)continue;
                    else{
                        res=jump(s,pos+i,n,s[pos+i]-s[pos],p); 
                        if(res)return(res);
                        p[pos+i].push_back(s[pos+i]-s[pos]);                        
                    }
                }
                else{
                    res=jump(s,pos+i,n,s[pos+i]-s[pos],p); 
                    if(res)return(res);
                    p[pos+i].push_back(s[pos+i]-s[pos]);
                }
            }            
        }
        return(res);
    }
    bool canCross(vector<int>& stones) {
        int n=stones.size();
        if(n<1)return(true);
        if(stones[1]>1)return(false);
        vector<vector<int>> p(n, vector<int>(1, -1));
        return(jump(stones,1,stones.size()-1,1,p));
    }
};
// @lc code=end

