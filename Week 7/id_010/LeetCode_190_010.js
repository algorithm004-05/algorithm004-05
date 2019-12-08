/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    var result = 0;
    for(let i = 0; i<32; ++i){
        result <<=1;
        if(n&1 ===1){
            result+=1;
        }
        n>>=1;
    }
    
    return result >>>0;
};