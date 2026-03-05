package Homework2;

public class Task1 {
    public static boolean isNumber(String symbol) {
        if (symbol.isEmpty()){
            return false;
        }
        int start = 0;
        if (symbol.charAt(0) == '-' && symbol.length() > 1){
            start = 1;
        }
        for (int i = start; i < symbol.length(); i++) {
            if (!isDigit(symbol.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static int calculate(String expression){
        String[] symbols = expression.split(" ");
        Stack stack = new Stack();
        for (String symbol : symbols){
            if (isNumber(symbol)){
                stack.add(new StackNode(Integer.parseInt(symbol)));
            } else {
                if (stack.getSize() < 2){
                    throw new IllegalArgumentException("недостаточно циферок");
                }
                int b = stack.remove().getValue();
                int a = stack.remove().getValue();
                if (symbol.equals("+")){
                    stack.add(new StackNode(a + b));
                } else if (symbol.equals("-")) {
                    stack.add(new StackNode(a - b));
                } else if (symbol.equals("*")) {
                    stack.add(new StackNode(a * b));
                } else if (symbol.equals("/")) {
                    if (b == 0){
                        throw new IllegalArgumentException("делить на ноль нельзя");
                    }
                    stack.add(new StackNode(a / b));
                } else {
                    throw new IllegalArgumentException("такого я не знаю");
                }
            }
        }
        if (stack.getSize() != 1){
            throw new IllegalArgumentException("чето не то");
        }
        return stack.remove().getValue();
    }
}
