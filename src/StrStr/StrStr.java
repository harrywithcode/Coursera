package StrStr;

//在一个大string中找needle出现的位置。*可以表示任何字母
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int result = -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) || needle.charAt(0) == '*') {
                boolean find = true;

                for (int j = 0; j < needle.length(); j++) {
                    if (i + j >= haystack.length() ||
                            (needle.charAt(j) != '*' && haystack.charAt(i + j) != needle.charAt(j))) {
                        find = false;
                        break;
                    }
                }

                if (find == true) {
                    result = i;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        String heap = "abcdefg";
        String needle = "*c*";
        System.out.println(s.strStr(heap, needle));
    }
}
