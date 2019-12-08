
/**
 * 二分查找模板
 * 
 *    left < right 2个元素比较  最终边界left和right相同，用任意一个判断
 *    int mid = left + ((right - left + 1)>>1)  mid为第2个  第2个值为右边值则变动右边界right = mid - 1; left = mid; binarySearch
 *    int mid = left + ((right - left)>>1)      mid为第1个  第1个值为左边值则变动左边界left = mid + 1;right = mid;  binarySearch1
 * 
 *     left <= right 2个元素比较  左left=mid+1，右right=mid-1  
 *     target在left=mid+1 则返回相反边界right且right>=0判断       binarySearch2
  *    target在right=mid-1则返回相反边界left且left < a.length判断 binarySearch3
 * 
 */
public class BinarySearchTemplate{

    public static void main(String[] args) {
        int[] aa = new int[] {-2,0, 1, 2, 3, 4, 5, 6,7,8};
        int[] aa1 = new int[] { 0, 1, 2, 3, 4, 5 };
        int[] aa2 = new int[]{ 0, 1, 2, 3, 4, 5, 6 };
        BinarySearchTemplate t = new BinarySearchTemplate();
        for (int i = 0; i < aa.length; i++) {
            int target = aa[i];
            System.out.print(t.binarySearch(aa1, target));
            System.out.print(t.binarySearch(aa2, target));

            System.out.print(t.binarySearch1(aa1, target));
            System.out.print(t.binarySearch1(aa2, target));

            System.out.print(t.binarySearch2(aa1, target));
            System.out.print(t.binarySearch2(aa2, target));

            System.out.print(t.binarySearch3(aa1, target));
            System.out.println(t.binarySearch3(aa2, target));
        }

    }

    
    /**
     * 
     *    left < right 2个元素比较  最终边界left和right相同，用任意一个判断
     **** int mid = left + ((right - left + 1)>>1)  mid为第2个  则变动边界right = mid - 1; left = mid;
     *    int mid = left + ((right - left)>>1)      mid为第1个  则变动边界left = mid + 1;right = mid;
     * @param a
     */
    public int binarySearch(int[] a,int target){
        if(null == a || 0 == a.length){
            return -1;
        }
        int left = 0,right = a.length -1;
        while(left < right){
            int mid = left + ((right - left + 1)>>1);
            if(a[mid] > target){
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if(a[left] == target){
            return left;
        }
        return -1;
    }

    /**
     *    left < right 2个元素比较  最终边界left和right相同，用任意一个判断
     *    int mid = left + ((right - left + 1)>>1)  mid为第2个  则变动边界right = mid - 1; left = mid;
     **** int mid = left + ((right - left)>>1)      mid为第1个  则变动边界left = mid + 1;right = mid;
     * @param a
     * @param target
     * @return
     */
    public int binarySearch1(int[] a,int target){
        if(null == a || 0 == a.length){
            return -1;
        }
        int left = 0,right = a.length -1;
        while(left < right){
            int mid = left + ((right - left)>>1);
            if(a[mid] >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if(a[left] == target){
            return left;
        }
        return -1;
    }

    /**
     * 
     *    left <= right 2个元素比较  左left=mid+1，右right=mid-1  
     **** target在left=mid+1 则返回right且right>=0判断
     *    target在right=mid-1则返回left且left < a.length判断
     * @param a
     * @param target
     * @return
     */
    public int binarySearch2(int[] a,int target){
        if(null == a || 0 == a.length){
            return -1;
        }
        int left = 0,right = a.length -1;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if(a[mid] > target){
                right = mid -1;
            } else {
                left = mid + 1;
            } 
        }

        if(right >= 0 && a[right] == target){
            return right;
        }
        return -1;
    }

    /**
     * 
     *    left <= right 2个元素比较  左left=mid+1，右right=mid-1
     *    target在left=mid+1 则返回right且right>=0判断
     **** target在right=mid-1则返回left且left < a.length判断
     * @param a
     * @param target
     * @return
     */
    public int binarySearch3(int[] a,int target){
        if(null == a || 0 == a.length){
            return -1;
        }
        int left = 0,right = a.length -1;
        while(left <= right){
            int mid = left + ((right - left)>>1);
            if(a[mid] >= target){
                right = mid -1;
            } else {
                left = mid + 1;
            } 
        }
        if(left < a.length && a[left] == target){
            return left;
        }
        return -1;
    }

    /**
     * 递归
     * @param a
     * @return
     */
    public int binarySearch4(int[] a,int target){
        if(null == a || 0 == a.length){
            return -1;
        }
        
        return -1;
    }
    
}