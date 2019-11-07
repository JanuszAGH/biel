package pl.janusz.buchalka.dsa.pt05.palindrome;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class PalindromeChecker {

    private static Deque<String> stack = new LinkedList<>();
    private static Deque<String> queue = new LinkedList<>();

    public static boolean isPalindrome(String word) {

        stack.clear();
        queue.clear();

        if (word == null) {
            return true;
        }

        word = word.trim();
        word = word.toLowerCase();
        String regexp = "\\s+";
        word = word.replaceAll(regexp, "");
        word = word.replaceAll("\'", "");

        for (int i = 0; i < word.length(); i++) {
            final String s = word.charAt(i) + "";
            stack.push(s);
            queue.add(s);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }

//        if (word.length() == 0) {
//            return true;
//        }
//
//        return check(word, 0, word.length() - 1);

//        for (int i = 0; i < word.length(); i++) {
//            stack.push(""+word.charAt(i));
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!stack.isEmpty()) {
//            stringBuilder.append(stack.pop());
//        }
//
//        return stringBuilder.toString().equals(word);

//        int left = 0;
//        int right = word.length() - 1;
//
//        while (left <= right) {
//            stack.push(word.charAt(left) + "");
//            left++;
//            String corresponding = word.charAt(right) + "";
//            right--;
//            if (!stack.pop().equals(corresponding)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    private static boolean check(String word, int left, int right) {
//
//        if (left > right) {
//            return true;
//        }
//
//        if (word.charAt(left) != word.charAt(right)) {
//            return false;
//        }
//
//        return check(word, ++left, --right);
//    }
}
