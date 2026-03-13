import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generatePT(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(1)));
        for(int answerIndex = 0;answerIndex<numRows-1;answerIndex++){
            List<Integer> pushArray = new ArrayList<>();
            int i=0, j=1;
            for(int pIndex = 0; pIndex <= answer.get(answerIndex).size(); pIndex++ ){
                if(pIndex == 0 || pIndex == answer.get(answerIndex).size()){
                    pushArray.add(1);
                }else{
                    pushArray.add((answer.get(answerIndex).get(i) + answer.get(answerIndex).get(j)));
                    i++;j++;
                }
            }
            answer.add(pushArray);
        }

        return answer;

    }

    public static void main(String[] args){
        List<List<Integer>> array = new ArrayList<>();

        array = generatePT(5);

        System.out.println(array);
    }
}
