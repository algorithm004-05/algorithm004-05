class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        num_rows = len(matrix)
        if num_rows == 0:
            return 0
        num_cols = len(matrix[0])
        opt = [[0 for _ in range(num_cols+1)] for _ in range(num_rows+1)]
        max_len = 0
        for i in range(1, num_rows+1):
            for j in range(1, num_cols+1):
                if matrix[i-1][j-1] == "1":
                    opt[i][j] = min(opt[i-1][j], opt[i][j-1], opt[i-1][j-1]) + 1
                    max_len = max(max_len, opt[i][j])
        return max_len**2