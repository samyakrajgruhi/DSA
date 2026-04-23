import java.util.*;

public class DecodeTheSlantedCipherText {

    public static String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1){
            return encodedText;
        }
        int col = encodedText.length() / rows;
        if(col == 1){
            return encodedText;
        }

        StringBuilder answer = new StringBuilder();

        for(int startCol = 0;startCol < col; startCol++){
            int r=0;
            int c = startCol;

            while(r < rows && c < col){
                answer.append(encodedText.charAt(r*col+c));
                r++;c++;
            }
        }

        int end = answer.length() - 1;
        while( end >=0 && answer.charAt(end) == ' ') end --;

        return answer.substring(0,end);
    }
    public static void main(String[] args) {
        String encodedText = "coding";
        System.out.println(decodeCiphertext(encodedText,1));
    }
}
