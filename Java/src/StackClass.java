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
    public static void main(String[] args){
        Stack<Integer>s= new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);


        print(s,80);
        System.out.println(s);
    }

}