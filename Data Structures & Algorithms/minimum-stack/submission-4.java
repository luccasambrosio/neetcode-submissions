class MinStack {

    Deque<Integer> main;
    Deque<Integer> min;
    public MinStack() {
        main = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        main.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if (main.isEmpty()) return;
        if(main.pop().equals(min.peek())){
            min.pop();
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
