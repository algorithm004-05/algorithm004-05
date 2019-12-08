/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    var s_len = s.length, t_len = t.length
    if(s_len !== t_len) return false
    var s_map = new Map()
    for(var i = 0; i<s_len; ++i){
        if(s_map[s[i]] ==null) s_map[s[i]] = 0
        else s_map[s[i]]++
    }
    console.log(s_map)
    for(var j = 0; j < t_len;++j){
        if(s_map[t[j]]>=0) s_map[t[j]]--
        else return false
    }
   
    return true
};