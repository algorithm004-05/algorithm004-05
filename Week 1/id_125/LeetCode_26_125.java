/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.16 23:16
 * @Description:
 */
public class A26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    /*
     * 可以存在解法2：新建数组，同样用双指针，将不同元素依次放入即可
     * 如果允许新建数组的。
     * 时间: O(n)
     * 空间：O(n)
     */

    /*
     * 交换数字位置，首先数组是有序的。
     * 分出两个指针，i指针随着for循环移动，j指针随着排序的情况移动。
     * 当num[i] != num[j] 的时候，应该交换 num[j+1] 与 num[i] 的值
     * 并且继续重复上面的步骤
     * 时间复杂度：时间跟数组大小有关系，故： O(n)
     * 空间： O(1)
     */
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
				/* 优化点：如果数组为 1,2,3,4,5。
				 * 那么可以不用交换任何元素，所以增加添加一个小判断，
				 * 当 i - j > 1 时，才进行复制.
				 * 但是运行所消耗的内存更高了？？
				 */
				 if(i - j > 1) {
					// 末尾位置最后面的数值不再关注，所以，可以不用给i赋值
					nums[j + 1] = nums[i]; 
				}
				j++;
            }
        }
        return ++j;
    }
}
