/*
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    //广度优先算法遍历，
    //1、首先用*号代替字符数组里的一个字符， 产生一张图
    let graph = {}
    for (let i = 0; i < wordList.length; i++) {
        let s = wordList[i]
        for (let j = 0; j < s.length; j++) {
            let vt = s.substr(0, j) + "*" + s.substr(j + 1, s.length);
            if (!graph[vt]) {
                graph[vt] = [s]
            } else {
                graph[vt].push(s)
            }
        }
    }

    //2、开始遍历查找
    let que = []
    que.push({key: beginWord, level: 1})
    let visted = {beginWord: 1}
    let _search = function () {
        //递归中止，队列里没有成员了
        if (que.length == 0) {
            return 0
        }

        //递归处理
        let node = que.shift()
        let s = node.key
        let level = node.level
        for (let j = 0; j < s.length; j++) {
            let vt = s.substr(0, j) + "*" + s.substr(j + 1, s.length);
            let ws = graph[vt]
            if (ws) {
                for (let i = 0; i < ws.length; i++) {
                    let e = ws[i]
                    if (!visted[e]) {
                        if (e == endWord) {
                            return level + 1
                        }
                        visted[e] = 1
                        que.push({key: e, level: level + 1})
                    }
                }
            }
        }
        return _search()
    }

    return _search()
};