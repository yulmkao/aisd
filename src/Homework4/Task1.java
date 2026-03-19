package Homework4;

public class Task1 {
    public static boolean isShifted(String s, String t) {
        return (s.length() == t.length()) && (s + s).contains(t);
    }

    public static void main(String[] args) {
        System.out.println(isShifted("макс", "аксм"));
        System.out.println(isShifted("макс", "скам"));
        System.out.println(isShifted("мама", "амам"));
    }
}