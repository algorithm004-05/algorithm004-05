package id_105;

public class LeetCode_74_105 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if(matrix[mid].length == 0){
                break;
            }
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                int left = 0;
                int right = matrix[mid].length - 1;
                while (left <= right) {
                    int mmid = (left + right) / 2;
                    if (matrix[mid][mmid] == target) {
                        return true;
                    }
                    if (matrix[mid][left] <= target && target <= matrix[mid][mmid]) {
                        right = mmid;
                    } else {
                        left = mmid + 1;
                    }
                }
            }
            if (matrix[top][0] <= target && target <= matrix[mid][0]) {
                bottom = mid;
            } else {
                top = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_74_105 l = new LeetCode_74_105();

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};




       boolean re = l.searchMatrix(matrix, 3);
        System.out.println(re);
    }
}
