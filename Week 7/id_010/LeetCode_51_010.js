/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
   const res = []
   backtrack(res,n)
    return res
};

function backtrack(res, n, board =[], r =0){
    if(r === n){
        res.push(board.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n -c - 1)));
        return;
    }
    
    for(let c = 0; c<n; c++){
        if(!board.some((bc,br) => bc === c || bc === c+r-br || bc === c-r+br)){
            board.push(c);
            backtrack(res, n, board, r+1);
            board.pop();
        }
    }
}