# 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
#
# 你可以对一个单词进行如下三种操作：
#
# 插入一个字符
# 删除一个字符
# 替换一个字符
# 示例 1:
#
# 输入: word1 = "horse", word2 = "ros"
# 输出: 3
# 解释:
# horse -> rorse (将 'h' 替换为 'r')
# rorse -> rose (删除 'r')
# rose -> ros (删除 'e')
# 示例 2:
#
# 输入: word1 = "intention", word2 = "execution"
# 输出: 5
# 解释:
# intention -> inention (删除 't')
# inention -> enention (将 'i' 替换为 'e')
# enention -> exention (将 'n' 替换为 'x')
# exention -> exection (将 'n' 替换为 'c')
# exection -> execution (插入 'u')
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/edit-distance
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution:
    def minDistance(self, word1, word2, cache={}):
        if not word1 and not word2:
            return 0
        if not len(word1) or not len(word2):
            return len(word1) or len(word2)
        if word1[0] == word2[0]:
            return self.minDistance(word1[1:], word2[1:])
        if (word1, word2) not in cache:
            inserted = 1 + self.minDistance(word1, word2[1:])
            deleted = 1 + self.minDistance(word1[1:], word2)
            replaced = 1 + self.minDistance(word1[1:], word2[1:])
            cache[(word1, word2)] = min(inserted, deleted, replaced)
        return cache[(word1, word2)]
