class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0){
            return false;
        }
        if(matrix.length > 0 && matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[row - 1][column - 1]){
            return false;
        }
        
        int r = row - 1;
        while(r >= 0 && target < matrix[r][0]){
            r--;
        }
        
        int left = 0;
        int right = column - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if(matrix[r][mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return matrix[r][left] == target;
    }
}