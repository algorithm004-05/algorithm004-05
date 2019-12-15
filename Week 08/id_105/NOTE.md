# NOTE

```text
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
  
       int cols = obstacleGrid[0].length;
        int[] nums = new int[cols];
        nums[0] = 1;
        for (int[] rows : obstacleGrid) {
            for (int i = 0; i < rows.length; i++) {
                if (rows[i] == 1) {
                    nums[i] = 0;
                } else if (i > 0){
                    nums[i] += nums[i - 1];
                }
            }
        }

        return nums[cols - 1];
    }
```

