/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if(n===1) return 1
    let nArray = []
    nArray.length = n+1
    nArray[1] = 1
    nArray[2] = 2
    for(let i = 3; i<=n; ++i){
        nArray[i] = nArray[i-1] + nArray[i-2]
    }
    return(nArray[n])
};