package Semestrovka1;

public class AATree {
    private Node root;

    public void insert(int value) {
        root = insert(value, root);
    }

    public boolean find(int value) {
        return find(value, root) != null;
    }

    public void delete(int value) {
        root = delete(value, root);
    }

    // операция поиска
    private Node find(int valueToFind, Node tree) {
        if (tree == null) {
            return null;
        }
        if (valueToFind == tree.getValue()) {
            return tree;
        }
        //рекурсивный поиск в ветках
        if (valueToFind < tree.getValue()) {
            return find(valueToFind, tree.getLeft());
        } else {
            return find(valueToFind, tree.getRight());
        }
    }

    // операция добавления элемента
    private Node insert(Integer inputNumber, Node tree) {
        if (tree == null) {
            return new Node(inputNumber, 1, null, null);
        } else if (inputNumber < tree.getValue()) {
            tree.setLeft(insert(inputNumber, tree.getLeft()));
        } else if (inputNumber > tree.getValue()) {
            tree.setRight(insert(inputNumber, tree.getRight()));
        }
        // если inputNumber == tree.value, мы ничего не создаем; повторений быть не должно, чтобы не ломать балансировку
        tree = skew(tree);
        tree = split(tree);
        return tree;
    }

    // операция удаления элемента
    private Node delete(int valueToDelete, Node tree) {
        if (tree == null) {
            return null;
        }
        if (valueToDelete > tree.getValue()) {
            tree.setRight(delete(valueToDelete, tree.getRight()));
        } else if (valueToDelete < tree.getValue()) {
            tree.setLeft(delete(valueToDelete, tree.getLeft()));
        } else {
            // нашли нужный узел для удаления
            if (leaf(tree)) {
                return null; // если это лист (нет детей), то просто стираем его
            } else if (tree.getLeft() == null) {
                // если нет левого ребенка, ищем замену справа
                Node replacement = successor(tree);
                tree.setRight(delete(replacement.getValue(), tree.getRight()));
                tree.setValue(replacement.getValue());
            } else {
                // если есть левый ребенок, ищем замену слева
                Node replacement = predecessor(tree);
                tree.setLeft(delete(replacement.getValue(), tree.getLeft()));
                tree.setValue(replacement.getValue());
            }
        }
        // Сбалансируем дерево:
        tree = decreaseLevel(tree); // проверяем и понижаем уровни
        tree = skew(tree);          // убираем левые горизонтальные ребра
        tree.setRight(skew(tree.getRight()));

        if (tree.getRight() != null) {
            tree.setRight(skew(tree.getRight()));
            if (tree.getRight().getRight() != null) {
                tree.getRight().setRight(skew(tree.getRight().getRight()));
            }
        }

        tree = split(tree);         // убираем двойные правые ребра
        if (tree.getRight() != null) {
            tree.setRight(split(tree.getRight()));
        }
        return tree;
    }

    // вспомогательные методы для балансировки дерева
    //поворот влево и повышение уровня
    public Node split(Node tree) {
        if (tree == null) {
            return null;
        }
        else if (tree.getRight() == null || tree.getRight().getRight() == null) {
            return tree;
        }
        // проверяем, один ли уровень у родителя и внука, т.е. существует ли два последовательных
        // правых горизонтальных ребра
        else if (tree.getLevel() == tree.getRight().getRight().getLevel()) {
            // существует два правых горизонтальных ребра, берем центральную вершину, «поднимаем» ее
            // и возвращаем указатель на нее
            Node rightChild = tree.getRight();
            Node newLeft = new Node(tree.getValue(), tree.getLevel(), tree.getLeft(), rightChild.getLeft());
            return new Node(rightChild.getValue(), rightChild.getLevel() + 1,
                    newLeft, rightChild.getRight());
        }
        return tree;
    }

    //поворот вправо
    public Node skew(Node tree) {
        if (tree == null) {
            return null;
        } else if (tree.getLeft() == null) {
            return tree;
        } else if (tree.getLeft().getLevel() == tree.getLevel()) {
            // выполняем правое вращение
            return new Node(tree.getLeft().getValue(), tree.getLeft().getLevel(), tree.getLeft().getLeft(),
                    new Node(tree.getValue(), tree.getLevel(), tree.getLeft().getRight(), tree.getRight()));
        } else {
            return tree;
        }
    }

    // удаление вершины
    public Node decreaseLevel(Node tree) {
        if (tree == null) {
            return null;
        }
        int leftLvl = getLevel(tree.getLeft());
        int rightLvl = getLevel(tree.getRight());
        int shouldBe = Math.min(leftLvl, rightLvl) + 1;
        if (shouldBe < tree.getLevel()) {
            tree.setLevel(shouldBe);
            if (tree.getRight() != null && shouldBe < tree.getRight().getLevel()) {
                tree.getRight().setLevel(shouldBe);
            }
        }
        return tree;
    }

    private int getLevel(Node tree) {
        return tree == null ? 0 : tree.getLevel();
    }

    // проверка, является ли узел листом
    boolean leaf(Node tree) {
        return tree.getLeft() == null && tree.getRight() == null;
    }

    // поиск преемника
    Node successor(Node tree) {
        Node current = tree.getRight();
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    // поиск предшественника
    Node predecessor(Node tree) {
        Node current = tree.getLeft();
        while (current != null && current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node tree) {
        if (tree == null) {
            return;
        }
        printInOrder(tree.getLeft());
        System.out.print(tree.getValue() + " ");
        printInOrder(tree.getRight());
    }

    public int findMin() {
        if (root == null) {
            throw new RuntimeException("дерево пустое");
        }
        Node current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }
}
