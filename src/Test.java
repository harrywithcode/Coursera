import java.util.*;

public class Test {
    /*
     * Complete the function below.
     */
    static int palindrome(String s) {
        int result = 0;
        Set<String> nonDuplicatedContainer = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString)) {
                    nonDuplicatedContainer.add(subString);
                }
            }
        }
        result = nonDuplicatedContainer.size();
        return result;
    }
    private static boolean isPalindrome (String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void mian(String[] args) {
        Test t = new Test();
        String input = "aabaa";
        System.out.print(Test.palindrome(input));
    }
}
