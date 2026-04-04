class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case "+", "-", "*", "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(switch(t){
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> 0;
                    });
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
