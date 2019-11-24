#
# @lc app=leetcode.cn id=433 lang=python3
#
# [433] 最小基因变化
#
# https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
#
# algorithms
# Medium (43.73%)
# Likes:    17
# Dislikes: 0
# Total Accepted:    1.1K
# Total Submissions: 2.4K
# Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
#
# 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
# 
# 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
# 
# 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
# 
# 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
# 
# 现在给定3个参数 — start, end,
# bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
# 
# 注意:
# 
# 
# 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
# 所有的目标基因序列必须是合法的。
# 假定起始基因序列与目标基因序列是不一样的。
# 
# 
# 示例 1:
# 
# 
# start: "AACCGGTT"
# end:   "AACCGGTA"
# bank: ["AACCGGTA"]
# 
# 返回值: 1
# 
# 
# 示例 2:
# 
# 
# start: "AACCGGTT"
# end:   "AAACGGTA"
# bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
# 
# 返回值: 2
# 
# 
# 示例 3:
# 
# 
# start: "AAAAACCC"
# end:   "AACCCCCC"
# bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
# 
# 返回值: 3
# 
# 
#

# @lc code=start
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if start == end :
            return 0
        if bank == []:
            return -1
        genes = ['A','G','C','T']
        level = 0
        queue = [start]
        while len(queue)!=0:
            size1 = len(queue)
            while size1>0:
                cur = queue[0]
                queue = queue[1:]
                if cur == end:
                    return level
                for i in range(len(cur)):
                    for g in genes:
                        if g != cur[i]:
                            neww = cur[0:i]+g+cur[i+1:]
                            print(neww)
                        #数组组合为字符串
                            if neww in bank:
                                bank.remove(neww)
                                queue.append(neww)
                size1 -=1
            level+=1
        return -1
# @lc code=end

