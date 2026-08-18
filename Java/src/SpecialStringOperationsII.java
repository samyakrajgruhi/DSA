public class SpecialStringOperationsII {
    public static char processStr(String s, long k) {
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
        if(k >= result.length()){
            return '.';
        }
        return 'c';
    }

    public static void main(String[] args){
        String s = "a#b%*";

        char result = processStr(s,1);
        System.out.println(result);
    }
}
