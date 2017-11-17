package PrefixSubSuffix;
import java.util.*;
//三个string，其中prefix和suffix是固定的。让你从中间的text里面找出一个substring出来，
//然后prefix + substring + suffix，两个加号的地方是重叠部分，求重叠最大情况时的substring

//其实这个text就相当于一个pool，从里面选择合适的substring和固定的prefix，suffix算积分
//直接找出所有substring挨个比较。这题简单的地方在于prefix和suffix是固定的，不要找他们的substring
public class PrefixSubSuffix {
    public String findMaxScore(String prefix, String text, String suffix) {
        int max = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                String subString = text.substring(i, j);
                int preScore = calculatePre(prefix, subString);
                int sufScore = calculateSuf(suffix, subString);

                if (preScore + sufScore > max) {
                    max = preScore + sufScore;
                    result = subString;
                }
            }
        }
        return result;
    }
    private int calculatePre(String prefix, String subString) {
        return 0;
    }

    private int calculateSuf(String suffix, String subString) {
        int result = 0;

        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) == suffix.charAt(0)) {
                for (int j = 0; j < suffix.length(); j++) {
                    if (subString.charAt(i + j) != suffix.charAt(i)) {
                        result = 0;
                        break;
                    } else {
                        result++;
                    }
                }
                if (result == 0) {
                    continue;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrefixSubSuffix prefixSubSuffix = new PrefixSubSuffix();
        String prefix = "bruno";
        String text = "nothing";
        String suffix = "ingenious";
        String result = prefixSubSuffix.findMaxScore(prefix, text, suffix);
        System.out.println(result);
    }
}
