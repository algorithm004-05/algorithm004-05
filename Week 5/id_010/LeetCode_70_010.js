/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if(n<0) return 0;
    else if(n === 1) return 1;
    else{
        let a =0,
            b =1,
            c =0;
        for(let i = 0; i< n;++i){
            c =a + b;
            a = b;
            b = c;
        }
        return c
    }
};