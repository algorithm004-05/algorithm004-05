/**
     * considering unicode, you can replece 26 with 256
     * this is to say, initilizing array is:
     * int[] sRow = new int[256]
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //attention: s or t => ""
        if (s.equals("") && t.equals("")) return true;
        if (s.equals("") || t.equals("")) return false;
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) return false;
        int[] sRow = new int[26], tRow = new int[26];
        for (char ch1 : s.toCharArray()) {
            sRow[ch1 - 'a']++;
        }
        for (char ch2 : t.toCharArray()) {
            tRow[ch2 - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sRow[i] != tRow[i]) return false;
        }
        return true;
    }
