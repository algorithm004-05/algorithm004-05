#@author:leacoder
#@des:  动态规划  编辑距离

'''
二维动态规划：
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 
只定义一维 DP[i] 不能有效简化问题的处理
使用 二维 DP[i][j]，表示 word1 的 i 个字母 与 word2 的 第 j 个字母 相同 需要的操作步骤数

a、重复子问题
word1的第i 个字母 word2 的 第 j 个字母，通过 插入 删除 替换 （上一的操作次数 + 1）使其相同

b、状态定义
二维 DP[i][j]，表示 word1 的 i 个字母 与 word2 的 第 j 个字母 相同 需要的操作步骤数

c、dp 方程
注意 i j 有效数据从 1 开始

DP[i][j]  A、 word1 的 i 个字母 与 word2 的 第 j 个字母 相同
                    DP[i][j] =  DP[i-1][j-1]  #不操作
          B、不相同,需要进行 插入 删除 或者 替换操作
                    DP[i][j]  =  min(DP[i-1][j] + 1,DP[i][j-1] + 1,DP[i-1][j-1]+1)
                    DP[i-1][j] + 1 :  word1 插入一个字符 i - 1 变为 i
                    DP[i][j-1] + 1 :  word1 删除一个字符 = word2 插入一个字符  j - 1 变为 j
                    DP[i-1][j-1]+1 :  word1 word2 都替换一个字符

'''
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        len1 = len(word1)
        len2 = len(word2)

        # 特殊情况
        #if len1 == 0 or len2 == 0:
        #    return len1 + len2

        DP = [[0 for _ in range(len2+1)] for _ in range(len1+1)]
        # DP初始  特殊情况处理
        for i in range(len1+1):
            DP[i][0] = i
        for j in range(len2+1):
            DP[0][j] = j

        for i in range(1,len1+1):
            for j in range(1,len2+1):
                if word1[i - 1] == word2[j -1]:
                    DP[i][j] =  DP[i-1][j-1]
                else:
                    DP[i][j]  =  min(DP[i-1][j] + 1,DP[i][j-1] + 1,DP[i-1][j-1]+1)
        return DP[len1][len2]

