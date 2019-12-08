// 1.暴力排序
// 2.哈希表
class Solution {
public:
    bool isAnagram(string s, string t) {
          int *data = new int[26]();
// 定义一个int类型数组，长度为26即26个字母，用于记录 s中出现的次数 - t中出现的次数
          int n = s.length();
          int m = t.length();
          int temp;
          if(n!=m) return false;
          for(int i = 0;i<m;i++)
          {
              temp = s.at(i);
              data[temp-'a']++; // 先记录s中每个字母出现次数
          }
              
          for(int i = 0;i<n;i++){
              temp = t.at(i);
              data[temp-'a']--; // 再将t中每个字母出现的次数扣除
              if(data[temp-'a']<0) return false;
              // 如果这个字母的记录值为0，则s和t中出现的次数一样，反之次数不一样，也就是两个字符串不是有效的字母异位词
          }
        return true;
    }
};


class Solution{
    public:
    bool isAnagram(string s,string t){
        if(s.size()!=t.size())
            return false;
        unordered_map<int,int> umap;
        for(char ch:s){
            ++umap[ch];
        }
        for(char ch:t){
            if(umap[ch]>0){
                --umap[ch];
            }else{
                return false;
            }
        }
        return true;
    }
};



class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()){
            return false;
        }
            sort(s.begin(),s.end());
            sort(t.begin(),t.end());
            return s==t;
        }
}; 
