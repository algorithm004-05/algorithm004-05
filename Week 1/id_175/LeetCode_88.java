import java.util.Arrays;

/**
 * @Auther: shizeying
 * @Date: 19-10-20 20:22
 * @Description:
 */
public class LeetCode_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1Poi = m - 1;
		for (int num : nums2) {
			if (nums1[nums1Poi] == 0) {
				nums1[nums1Poi] = num;
				nums1Poi--;
			}
		}
		Arrays.sort(nums1);
	}
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int nums1Poi = m - 1, nums2Poi = n - 1, enuFinish = m + n - 1;
		while (nums1Poi >= 0 && nums2Poi >= 0) {
			nums1[enuFinish] = (nums1[nums1Poi] > nums2[nums2Poi] ? nums1[nums1Poi--] : 			nums2[nums2Poi--]);
			enuFinish--;
		}
		while (nums2Poi >= 0) {
			nums1[enuFinish--] = nums2[nums2Poi--];
		}
	}
}
