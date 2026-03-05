package Homework2;

public class Queue {
    private StackNode head;
    private StackNode tail;
    private int size;

    public void add(int value) {
        StackNode newNode = new StackNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setPrevious(newNode);
        }
        tail = newNode;
        size++;
    }

    public int remove(){
        if (isEmpty()){
            throw new IllegalStateException("в очереди пустота");
        }
        int value = head.getValue();
        head = head.getPrevious();
        size--;
        if (head == null){
            tail = null;
        }
        return value;
    }

    public int getHead(){
        if (isEmpty()){
            throw new IllegalStateException("в очереди пустота");
        }
        return head.getValue();
    }

    public void print(){
        StackNode current = head;
        while (current != null){
            System.out.println(current.getValue() + " ");
            current = current.getPrevious();
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}