/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    let m = grid.length
    let n = grid[0].length
    // let n = grid[0].length
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i + 1 < m && j + 1 < n) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1])
            } else if (i + 1 < m) {
                grid[i][j] += grid[i + 1][j]
            } else if (j + 1 < n) {
                grid[i][j] += grid[i][j + 1]
            }
        }
    }
    return grid[m-1][n-1]
};
