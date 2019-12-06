public class Solution {
    public int reverseBits(int n) {

	int i = 32;
	int low = 0;
	int res = 0;
	while (i-- > 0) {
	    low = 1 & n;
	    res = (res << 1) | low;
	    n = n >> 1;
	}
	return res;

    }

}