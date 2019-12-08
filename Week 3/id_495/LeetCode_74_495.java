class LeetCode_74_495 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
          new int[] {1,   3,  5,  7},
          new int[] {10, 11, 16, 20},
          new int[] {23, 30, 34, 50}
        }, 34));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int rl = 0, rr = n;
        int cl = 0, cr = m;

        while (rl <= rr && rl < n) {
            int row = rl + (rr-rl)/2;
            if (target >= matrix[row][0]) {
                rl = row + 1;
            }
            else {
                rr = row - 1;
            }
        }
        int searchRow = rl-1;
        if (rl-1 < 0) {
            return false;
        }
        while (cl <= cr && cl < m) {
            int col = cl + (cr-cl)/2;
            if (target >= matrix[searchRow][col]) {
                cl = col + 1;
            }
            else {
                cr = col - 1;
            }
        }
        int res = matrix[searchRow][cl-1];
        return res == target;
    }
}
