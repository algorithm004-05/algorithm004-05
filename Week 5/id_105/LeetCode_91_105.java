package id_105;


public class LeetCode_91_105 {



    public int numDecodings(String s) {


        if (s.length() == 0 || s.equals("0")) return 0;

        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0'){
                if (s.charAt(i - 1) == '1' || s.charAt(i -1) == '2'){
                    curr = pre;
                }else {
                    return 0;
                }

            }else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')){
                curr += pre;
            }
            pre = tmp;

        }
        return curr;
    }


    public static void main(String[] args) {
        LeetCode_91_105 l = new LeetCode_91_105();

        System.out.println(l.numDecodings("12"));
        System.out.println(l.numDecodings("226"));
        System.out.println(l.numDecodings("0"));
        System.out.println(l.numDecodings("120"));
        System.out.println(l.numDecodings("10"));
        System.out.println(l.numDecodings("12012"));

    }
}
