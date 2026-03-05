package Homework2;

public class Task2 {
    public static Queue merge(Queue q1, Queue q2){
        Queue result = new Queue();
        while (!q1.isEmpty() && !q2.isEmpty()){
            if (q1.getHead() <= q2.getHead()){
                result.add(q1.remove());
            } else {
                result.add(q2.remove());
            }
        }
        while (!q1.isEmpty()){
            result.add(q1.remove());
        }
        while (!q2.isEmpty()){
            result.add(q2.remove());
        }
        return result;
    }
}