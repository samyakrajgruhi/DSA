import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Revision {
    static void columnZero(int[][] mat, int col){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(j==col){
                    mat[i][j]=0;
                }
            }
        }
    }

    static void rowZero(int[][] mat,int row){
        for(int i=0;i<mat.length;i++){
            if(i==row){
                for(int j=0;j<mat[0].length;j++){
                    mat[i][j]=0;
                }
            }
        }
    }

    static void setZeroes(int[][] matrix){
        ArrayList<ArrayList<Integer>> indexes = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    indexes.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        for(int i=0;i< indexes.size();i++){
            rowZero(matrix,indexes.get(i).get(0));
            columnZero(matrix,indexes.get(i).get(1));
        }
    }

    static List<List<Integer>> generate(int numRows){
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        for(int row=1;row<numRows;row++){
            List<Integer> pushList = new ArrayList<>();
            int i=0;int j=1;
            while(i<row){};

        }

        return answer;
    }
    public static void main(String  [] args){

    }
    
}
