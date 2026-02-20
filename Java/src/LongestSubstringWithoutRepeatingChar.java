import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        String str = "";
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(str.contains(String.valueOf(c))){
                str = str.substring(str.indexOf(c)+1);
                str += c;

            }else{
                str += c;
            }
            maxLen = Math.max(str.length(),maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abdvdefg";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
