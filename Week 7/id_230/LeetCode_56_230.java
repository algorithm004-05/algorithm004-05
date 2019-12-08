/**
     * 1, don't forget sort again after merging,
     * 2, [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
     *   when i use this array to test,
     *   this make me understand
     *   sorting again after merging
     * 3, [[1,3],[0,2],[2,3],[4,6],[4,5],[5,5],[0,2],[3,3]]
     *   make me know :
     *   should compare a[i][1] and a[i - 1][1],
     *   not a[i][0] and a[i - 1][1]
     * 4, this solution win only 6.26% in all the answers, emmmm,,,,,,
     *
     * @param arr  two dimensional arrays
     * @return  two dimensional arrays
     */
     
    public static int[][] merge(int[][] arr) {
        int len = arr.length;
        int count = 0;
        //1,sort
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] tmp = arr[j];
                if (arr[j][0] < arr[i][0]) {
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        //2,merge
        for (int i = 1; i < len; i++) {
            if (arr[i][0] >= arr[i - 1][0] && arr[i][0] <= arr[i - 1][1]) {
                if (arr[i][1] <= arr[i - 1][1]) {
                    arr[i][1] = arr[i - 1][1];
                }
                arr[i][0] = arr[i - 1][0];
                arr[i - 1][0] = arr[i - 1][1] = 0;
                count++;
            }
        }
        //3, sort again
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] tmp = arr[j];
                if (arr[j][1] < arr[i][1]) {
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        //4,remove[0, 0]
        int[][] mergeArr = new int[arr.length - count][2];
        for (int i = 0; i < mergeArr.length; i++) {
            mergeArr[i][0] = arr[i + count][0];
            mergeArr[i][1] = arr[i + count][1];
        }
        return mergeArr;
    }
