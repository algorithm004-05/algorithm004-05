var hammingWeight = function(n) {
    let count = 0, mask = 1;
    for(let i = 0;i < 32; i++){
        if(n & mask) count++;
        mask <<= 1;
    }
    return count;
}