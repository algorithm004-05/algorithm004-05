/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g = g.sort((a,b) => {return a-b})
    s = s.sort((a,b) => {return a-b})
    let count = 0
    for(let i = 0, j =0; j< s.length; j++){
        if(i === g.length) break
        if(s[j]>=g[i]){
            ++count
            ++i
        }
    }
    
    
    return count
};