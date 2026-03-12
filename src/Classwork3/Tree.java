package Classwork3;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public void add(T value) {
        if (this.root == null) {
            this.root = new TreeNode<>(value);
        } else {
            add(this.root, value);
        }
    }

    private void add(TreeNode<T> current, T value) {
        if (current.getValue().compareTo(value) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(value));
            } else {
                add(current.getLeft(), value);
            }
        } else if (current.getValue().compareTo(value) <= 0) {
            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(value));
            } else {
                add(current.getRight(), value);
            }
        }
    }

    public TreeNode<T> get(T value) {
        TreeNode<T> current = root;
        while (current != null) {
            int result = value.compareTo(current.getValue());
            if (result == 0) {
                return current;
            }
            current = (result < 0) ? current.getLeft() : current.getRight();
        }
        return null;
    }

    public void remove(T value) {
        this.root = remove(this.root, value);
    }

    private TreeNode<T> remove(TreeNode<T> current, T value) {
        if (current == null) {
            return null;
        }
        int compare = value.compareTo(current.getValue());
        if (compare < 0) {
            current.setLeft(remove(current.getLeft(), value));
        } else if (compare > 0) {
            current.setRight(remove(current.getRight(), value));
        } else {
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            T smallestValue = findMin(current.getRight());
            current.setValue(smallestValue);
            current.setRight(remove(current.getRight(), smallestValue));
        }
        return current;
    }

    private T findMin(TreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public int getHeight() {
        return calculateHeight(this.root);
    }

    private int calculateHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
    }

    public void preOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    public void postOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }
}