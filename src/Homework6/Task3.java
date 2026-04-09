package Homework6;

public class Task3 {
    public static void main(String[] args) {
        String s = "i love itis";
        String result = "";
        String word = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word += c;
            } else {
                result = word + " " + result;
                word = "";
            }
        }
        result = word + " " + result;
        System.out.println(result);
    }
}