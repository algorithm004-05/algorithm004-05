var hammingWeight = function(n) {
    let count = 0;
    while(n != 0){
        n&=(n-1);
        count++;
    }
    return count;
};
