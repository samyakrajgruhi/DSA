import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i=s.length()-1;i>=0;i--){
            if(stack.isEmpty()){
                System.out.println("first");
                stack.push(s.charAt(i));
            }
            else if(stack.peek().equals(s.charAt(i))){
                System.out.println("Popping");
                stack.pop();
            }else{
                System.out.println("pushing");
                stack.push(s.charAt(i));
            }
        }
        System.out.println();
        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args){
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }
}
