import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    Stack<List<Integer>> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        if(stack.isEmpty()) {
            stack.push(List.of(value, value));
        } else {
            int currentMin = stack.peek().get(1);
            int newMin = Math.min(value, currentMin);
            stack.push(List.of(value, newMin));
        }
        System.out.println("After Push");
        System.out.println(stack);
    }

    public void pop() {
        System.out.println(stack.pop());
    }

    public int top() {
        List<Integer> top = stack.pop();
        return top.get(0);
    }

    public int getMin() {
        return stack.peek().get(1);
    }
}

class MinStackMain{
    public static void main(String[] args){
        MinStack stack = new MinStack();

        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(-2);
        stack.push(-1);
        stack.push(-2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
    }
}
