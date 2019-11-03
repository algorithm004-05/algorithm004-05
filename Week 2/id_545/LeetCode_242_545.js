// 242. 有效的字母异位词

// 排序 比较是否相等
// var isAnagram = function(s, t) {
//     return s.split('').sort().join('') == t.split('').sort().join('')
// };


// 哈希表
var isAnagram = function(s, t) {
    if (s.length != t.length) return false
    let dct = {}
    for(let i in s) {
        let m = s[i]
        dct[ m ] != undefined ? dct[ m ]++ : dct[ m ] = 1
    }

    for(let j in t) {
        let m = t[j]
        if (dct[ m ] != undefined) {
            dct[ m ]--
            if (dct[ m ] < 0) {
                return false
            }
        } else {
            return false
        }
    }
    return true
}