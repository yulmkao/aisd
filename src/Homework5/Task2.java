package Homework5;

import java.util.ArrayList;
import java.util.Comparator;

public class Task2 {
    public static int compareStrings(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            char letter1 = s1.charAt(i);
            char letter2 = s2.charAt(i);

            if (letter1 < letter2) {
                return -1;
            } else if (letter1 > letter2) {
                return 1;
            }
        }

        if (s1.length() < s2.length()) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("яблоко");
        words.add("ялта");
        words.add("як");
        words.add("я");

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return compareStrings(s1, s2);
            }
        };
        words.sort(stringComparator);
        System.out.println(words);
    }
}