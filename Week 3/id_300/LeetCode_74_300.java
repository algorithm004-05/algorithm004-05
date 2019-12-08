class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 遍历二维数组，获取二维数组中的一维数组
        for(int[] arr : matrix){
            // 获取一维数组的arr[0]和arr[length-1],确定target在哪个一维数组中
            if(arr.length>0) {
                if (arr[0] <= target && arr[arr.length - 1] >= target) {
                    // 二分查找target是否存在
                    return binarySearch(arr, target);
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return true;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
