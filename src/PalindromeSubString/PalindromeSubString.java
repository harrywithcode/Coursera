package PalindromeSubString;
import java.util.*;

public class PalindromeSubString {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    private void backTrack(List<List<String>> result, List<String> line, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(line));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //no skip
            if (isPalindrome(s, start, i)) {
                line.add(s.substring(start, i + 1));
                backTrack(result, line, s, i + 1);
                line.remove(line.size() - 1);
            }
        }
    }
    private boolean isPalindrome (String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
