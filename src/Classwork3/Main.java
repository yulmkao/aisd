package Classwork3;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int v : values) {
            tree.add(v);
        }

        System.out.print("прямой обход: ");
        tree.preOrder(tree.get(10));
        System.out.println();

        System.out.print("симметричный обход: ");
        tree.inOrder(tree.get(10));
        System.out.println();

        System.out.print("обратный обход: ");
        tree.postOrder(tree.get(10));
        System.out.println();

        System.out.println("высота дерева: " + tree.getHeight());

        System.out.println("удаляем узел 5");
        tree.remove(5);

        System.out.print("симметричный обход после удаления: ");
        tree.inOrder(tree.get(10));
        System.out.println();
    }
}