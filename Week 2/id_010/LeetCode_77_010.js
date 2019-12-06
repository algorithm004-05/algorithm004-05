/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let results = []
    var getResults = function(n,k,step,arr){
        if(arr.length === k){
            results.push(arr)
            return 
        }
        
        for(var i = step; i<=n;++i){
            getResults(n,k,i+1,[...arr,i])
        }
    }
    
    getResults(n,k,1,[])
    
    return results
};