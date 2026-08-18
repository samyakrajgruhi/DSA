public class SpecialStringOperationsI {
    /*
    *  '*' = remove last character from result
    *  '#' = duplicate current result and append it to itself.
    *  '%' = reverse the current result
    */
    public static String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '*' && result.length()>0){
                result.deleteCharAt(result.length()-1);
            }else if(s.charAt(i) == '#'){
                result.append(result);
            }else if(s.charAt(i) == '%'){
                result.reverse();
            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "a#b%*";

        String result = processStr(s);
        System.out.println(result);
    }
}
