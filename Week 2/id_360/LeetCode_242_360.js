/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

// 遍历两个字符串，用hash分别存储字母出现次数，遍历hash比较相同字母出现次数
var isAnagram = function(s, t) {
    let slen = s.length,
        tlen = t.length,
        objs = {},
        objt = {}
    if (slen != tlen) {
        return false
    }
    for (let i = 0; i < slen; i++) {
        if (objs[s[i]]) {
            objs[s[i]]++
        } else {
            objs[s[i]] = 1
        }
        if (objt[t[i]]) {
            objt[t[i]]++
        } else {
            objt[t[i]] = 1
        }
    }
    for (let char in objs) {
        if (objs[char] != objt[char]) {
            return false
        }
    }
    return true
};