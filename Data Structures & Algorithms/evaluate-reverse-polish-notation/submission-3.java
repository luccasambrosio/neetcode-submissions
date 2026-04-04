class Solution {

    public int calculate(int a, int b, char operator){
        switch(operator){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String t : tokens){
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int result = calculate(a, b, t.charAt(0));
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
