package Homework6;

import static Homework6.Tree.printSumOfChildren;

public class Task4 {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(13);
        tree.add(4);
        tree.add(22);
        tree.add(15);
        tree.add(7);
        tree.add(21);
        tree.add(31);
        printSumOfChildren(tree.getRoot());
    }
}
