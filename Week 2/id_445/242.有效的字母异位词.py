#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    # solution 1
    # def isAnagram(self, s: str, t: str) -> bool:
    #     dic1,dic2={},{}
    #     for c in s:
    #         dic1[c]=dic1.get(c,0)+1
    #     for c in t:
    #         dic2[c]=dic2.get(c,0)+1
    #     return dic1==dic2

# solution 2
    # def isAnagram(self, s: str, t: str) -> bool:
    #     return sorted(s)==sorted(t)
    # def isAnagram(self, s: str, t: str) -> bool:
    #     dic={}
    #     lens=len(s)
    #     if (lens != len(t)):
    #         return False
    #     for i in range(lens):
    #         dic[s[i]]=dic.get(s[i],0)+1
    #         dic[t[i]]=dic.get(t[i],0)-1
    #     for v in dic.values():
    #         if (v!=0):
    #              return False
    #     return True
    
    #solution 3
    # def isAnagram(self, s: str, t: str) -> bool:
    #     dic=[0]*26
    #     lens=len(s)
    #     if (lens != len(t)):
    #         return False
    #     for i in range(lens):
    #         dic[ord(s[i])-97]+=1
    #         dic[ord(t[i])-97]-=1
    #     for v in dic:
    #         if (v!=0):
    #              return False
    #     return True
    
        #solution 4
    # def isAnagram(self, s: str, t: str) -> bool:
    #     dic={}
    #     lens=len(s)
    #     if (lens != len(t)):
    #         return False
    #     for c in s:
    #         if c not in dic:
    #             dic[c]=1
    #         else:
    #             dic[c]+=1
    #     for i in t:
    #         if i not in dic:
    #             return False
    #         else:
    #             dic[i]-=1

    #     for v in dic.values():
    #         if (v!=0):
    #              return False
    #     return True
    #solution 5  fastest
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(s)==collections.Counter(t)

        # for c in s

    

        
# @lc code=end

