package id_105;

public class LeetCode_64_105 {

    public int minPathSum(int[][] grid) {

        //the first row init.
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int row = 1; row < grid.length; row++){
            for(int col = 1; col < grid[row].length; col++){
                grid[row][col] += Math.min(grid[row-1][col], grid[row][col-1]);
            }
        }
        int lastRow = grid.length -1;
        return grid[lastRow][grid[lastRow].length -1];
    }


    public static void main(String[] args) {
        int[][] nums = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        LeetCode_64_105 l = new LeetCode_64_105();
        int result = l.minPathSum(nums);
        System.out.println(result);
    }
}
