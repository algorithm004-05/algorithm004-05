/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    // 边界条件
    let index= wordList.indexOf(beginWord)
    if (index !== -1) {
        wordList.splice(index, 1)
    }
    if (wordList.length  === 0) {
        return 0
    }
    let queue = [beginWord]
    var res = 2
    while (queue.length !== 0) {
        let len = queue.length
        for (let i = 0; i < len; i++) {
            var str = queue.shift()
            for (let j = 0 ; j < wordList.length;) {
                if (diff(str, wordList[j])) {
                    var newStr = wordList.splice(j, 1)[0]
                    if (newStr === endWord) {
                        return res
                    } else {
                        queue.push(newStr)
                    }
                } else {
                    j++
                }
            }
        }
        res++
    }
    return 0
};

function diff (str1, str2) {
    let count = 0
    for (let i = 0; i < str1.length; i++) {
        str1[i] !== str2[i] && count++
        if (count > 1) {
            return false
        }
    }
    // 差距为1 返回true
    return true
}