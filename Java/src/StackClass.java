import java.net.Inet4Address;
import java.util.*;
public class StackClass{
    public static void print(Stack<Integer> s,int elem){
        if(s.isEmpty()){
            s.push(elem);
            return;
        }

        int top = s.pop();
        print(s,elem);
        s.push(top);

    }
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.peek();
                    int c = a + b;
                    stack.push(a);
                    stack.push(c);
                }
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for(int i:stack){
            sum += i;
        }
        return sum;
    }

    public static boolean isValid(String s){
        Stack<Character> brackets = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                brackets.push(c);
            }
            else if(c == ')' || c ==']' || c == '}'){
                if(brackets.isEmpty()){
                    return false;
                }
                char temp = brackets.pop();
                if(c == ')' && temp != '(') return false;
                if(c == ']' && temp != '[') return false;
                if(c == '}' && temp != '{') return false;
            }

        }
        return brackets.isEmpty();
    }
    public static void main(String[] args){
        String s = "()}[]";


        System.out.println(isValid(s));
    }

}